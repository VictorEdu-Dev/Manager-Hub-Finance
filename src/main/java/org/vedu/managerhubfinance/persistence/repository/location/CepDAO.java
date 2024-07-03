package org.vedu.managerhubfinance.persistence.repository.location;

import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

/**
 * Interface to define the methods that must be implemented by the CepDAOImpl
 * class.
 * 
 * @param <ID> the type of the identifier of the entity.
 * @param <E>  the type of the entity.
 * @deprecated since 1.0 for removal in the next version.
 */
@Deprecated(since = "1.0", forRemoval = true)
@Local
public interface CepDAO<ID, E> extends CrudRepository<ID, E> {
	public List<E> findAll(boolean withCity);
	public List<E> findByName(String name, boolean subtring);
	public Optional<E> findByStreet(String street);
	public void makeTransientById(ID id);
}
