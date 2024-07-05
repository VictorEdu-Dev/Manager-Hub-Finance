package org.vedu.managerhubfinance.service.basic;

import java.util.Map;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;

import jakarta.ejb.Local;

@Local
public interface LocationService {
	public void initialize();
	
	public Optional<String> getNumberCep(Map<String, String> properties);
	
	public Optional<Integer> getStateCode(String stateName);
	
	public Optional<String> getCityName(String cep);
	
	public Optional<Map<String, String>> getAddressInfo(String cepNumber);
	
	public void editCepInfo(Cep cep);
	
	public void destruct();
	
}
