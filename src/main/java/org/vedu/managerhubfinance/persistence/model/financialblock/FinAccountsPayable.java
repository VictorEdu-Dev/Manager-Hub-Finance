package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;
import org.vedu.managerhubfinance.persistence.model.groupperson.Partner;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = { 
		"accountTeller",
		"supplier",
		"sourceDocuments",
		"natureFin" })
@Table(name = "fin_payment_launch")
@Entity 
public class FinPaymentLaunch extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "source_documents_id", nullable = true, unique = false)
	private FinSourceDocuments sourceDocuments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nature_fin_id", nullable = true, unique = false)
	private FinNatureFin natureFin;
	
	@ManyToOne
	@JoinColumn(name = "account_teller_id", nullable = true)
	private AccountTeller accountTeller;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = true)
	private Partner supplier;
	
	@Basic
	@Column(name = "installment_quantity", nullable = true)
	private Integer installmentQuantity;
	
	@Basic
	@Column(name = "payment_value", nullable = true, precision = 12, scale = 2)
	private BigDecimal paymentValue;
	
	@Basic
	@Column(name = "launch_date", nullable = true)
	private LocalDateTime launchDate;
	
	@Basic
	@Column(name = "document_number", nullable = true, length = 100)
	private String documentNumber;
	
	@Basic
	@Column(name = "first_expiration_date", nullable = true)
	private LocalDateTime firstExpirationDate;
	
	@Basic
	@Column(name = "image_document", nullable = true, length = 100)
	private String imageDocument;
	
	@Basic
	@Column(name = "installment_interval", nullable = true, length = 2)
	private String installmentInterval;
	
	@Basic
	@Column(name = "fixed_day", nullable = true, length = 2)
	private String fixedDay;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name = "historical", nullable = true, length = 1000)
	private String historical;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fin_payment_type", nullable = true, length = 20)
	private FinPaymentTypeEnum finPaymentType;
	
	@Basic
	@Column(name = "due_date", nullable = true)
	private LocalDateTime dueDate;
	
	@Basic
	@Column(name = "limit_payment_date", nullable = true)
	private LocalDateTime limitPaymentDate;
	
	@Basic
	@Column(name = "consider_working_day", nullable = true)
	private Boolean considerWorkingDay;
}
