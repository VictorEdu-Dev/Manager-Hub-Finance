package org.vedu.managerhubfinance.persistence.repository.base;

import java.util.Optional;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;
import jakarta.persistence.LockModeType;

@Local
public interface StateDAO<ID, E> extends CrudRepository<ID, E> {
	public Optional<E> findByName(String name);
	public E findByName(String name, LockModeType lockModeType);
}
