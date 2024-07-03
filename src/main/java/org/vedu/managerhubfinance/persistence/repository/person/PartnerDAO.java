package org.vedu.managerhubfinance.persistence.repository.person;

import org.vedu.managerhubfinance.persistence.model.groupperson.Partner;

import jakarta.data.Order;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

@Repository
public interface PartnerDAO extends CrudRepository<Partner, Long> {
	 @Find
	 Page<Partner> findByName(String name, PageRequest pageRequest, Order<Partner> order);

	 @Query("select p from Partner p join p.person pe where pe.name = :name")
	 Partner findByName(@Param("name") String name);
}
