package org.vedu.managerhubfinance.persistence.repository.financialblock;

import java.util.Map;
import java.util.Set;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinPaymentLaunch;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface FinPaymentLaunchDAO extends CrudRepository<Long, FinPaymentLaunch> {
	public FinPaymentLaunch findBySourceDocumentsId(String sourceDocumentsId);
	public Set<FinPaymentLaunch> listAccountPayable(Map<String, Object> filters);
}
