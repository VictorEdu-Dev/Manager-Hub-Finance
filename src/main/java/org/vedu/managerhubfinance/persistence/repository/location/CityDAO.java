package org.vedu.managerhubfinance.persistence.repository.base;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;
import jakarta.persistence.LockModeType;

@Local
public interface CityDAO<ID, E> extends CrudRepository<ID, E> {
	public E findByName(String name);
	public E findByName(String name, LockModeType lockModeType);
}
