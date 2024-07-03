package org.vedu.managerhubfinance.persistence.repository.base;

import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface CepDAO<ID, E> extends CrudRepository<ID, E> {
	public List<E> findAll(boolean withCity);
	public List<E> findByName(String name, boolean subtring);
	public Optional<E> findByStreet(String street);
	public void makeTransientById(ID id);
}
