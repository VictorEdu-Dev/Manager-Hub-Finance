package org.vedu.managerhubfinance.persistence.repository.base.impl;

import org.vedu.managerhubfinance.persistence.model.groupbasic.City;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.CityDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.LockModeType;

@Stateless
public class CityDAOImpl extends CrudRepositoryImpl<String, City> implements CityDAO<String, City> {
	
	public CityDAOImpl() {
		super(City.class);
	}

	@Override
	public City findByName(String name) {
		String query = "SELECT c FROM City c WHERE c.name = :name";
	    return getEntityManager()
	    		.createQuery(query, City.class)
	    		.setParameter("name", name)
	    		.getSingleResult();
	}

	@Override
	public City findByName(String name, LockModeType lockModeType) {
		throw new UnsupportedOperationException();
	}
	
}
