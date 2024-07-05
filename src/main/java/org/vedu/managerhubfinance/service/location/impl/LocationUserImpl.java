package org.vedu.managerhubfinance.service.location.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.model.groupbasic.City;
import org.vedu.managerhubfinance.persistence.model.groupbasic.State;
import org.vedu.managerhubfinance.persistence.repository.location.CepDAO;
import org.vedu.managerhubfinance.persistence.repository.location.CepDataStore;
import org.vedu.managerhubfinance.persistence.repository.location.CityDAO;
import org.vedu.managerhubfinance.persistence.repository.location.StateDAO;
import org.vedu.managerhubfinance.service.location.LocationService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class LocationUserImpl implements LocationService {
	private Logger logger = Logger.getLogger(LocationUserImpl.class.getName());
	
	@EJB
	private CepDAO<String, Cep> cepDAO;
	
	private CepDataStore cepDataStore;
	
	@EJB
	private CityDAO<String, City> cityDAO;
	
	@EJB
	private StateDAO<String, State> stateDAO;

	@PostConstruct
	public void initialize() {
		System.out.println(logger.getName() + " initialized");
	}

	@Override
	public Optional<String> getNumberCep(Map<String, String> properties) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Optional<Integer> getStateCode(String stateName) {
		return stateDAO.findByName(stateName).map(State::getIbgeCode);
	}

	@Deprecated
	@Override
	public Optional<String> getCityName(String cepNumber) {
		return cepDAO.findSingleEntity(cepNumber).map(cep -> cep.getCity().getName());
	}

	@Override
	public Optional<Map<String, String>> getAddressInfo(String cepNumber) {
		Optional<Cep> cep = cepDAO.findSingleEntity(cepNumber);
		if (cep.isEmpty()) {
			return Optional.empty();
		}
		Map<String, String> addressInfo = new HashMap<>();
		addressInfo.put("city", cep.get().getNameCity());
		addressInfo.put("state", cep.get().getCity().getState().getName());
		addressInfo.put("cep", cep.get().getCep());
		addressInfo.put("street", cep.get().getStreet());
		addressInfo.put("neighborhood", cep.get().getNeighborhood());
		return Optional.of(addressInfo);
	}
	
	@Override
	public void editCepInfo(Cep cep) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@PreDestroy
	public void destruct() {
	    System.out.println(logger.getName() + " destroyed");
	}
}
