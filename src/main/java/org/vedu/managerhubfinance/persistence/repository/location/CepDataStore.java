package org.vedu.managerhubfinance.persistence.repository.location;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;

import jakarta.data.Order;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;

@Repository
public interface CepDataStore extends BasicRepository<Cep, String> {
	
	@Find
	@OrderBy("id")
	Page<Cep> findByCep(String cep, PageRequest pageRequest, Order<Cep> order);

}
