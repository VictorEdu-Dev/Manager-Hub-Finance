package org.vedu.managerhubfinance.service.finance;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.ejb.Local;

@Local
public interface PaymentLaunchService<ID, E> {

	public void registerAccountPayable(E entity);

	public void updateAccountPayable(E entity);

	public void deleteAccountPayable(E entity);

	public List<E> listAccountPayable();
	
	public Set<E> listAccountPayable(Map<String, Object> filters);

	E findBySourceDocumentsId(ID sourceDocumentsId);
	
	

}