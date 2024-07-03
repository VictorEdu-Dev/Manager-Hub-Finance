package org.vedu.managerhubfinance.persistence.repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.LockModeType;

/**
 * This interface defines the contract for a CRUD repository.
 * It is a generic interface that can be used with any type of primary key (ID) and entity class (E).
 *
 * @param <ID> the type of the primary key
 * @param <E> the type of the entity class
 * 
 * @deprecated Desde a versão 1.0. Use {@link jakarta.data.repository.CrudRepository}. Esta interface será removida em uma versão futura.
 */
@Deprecated(since = "1.0", forRemoval = true)
public interface CrudRepository<ID, E> {
	/**
	  * This method is used to find a single entity in the repository.
	  *
	  * @param key the key of the entity to find
	  * @return the found entity
	  */
	public Optional<E> findSingleEntity(ID key);
	
	/**
	 * This method is used to find a single entity in the repository with a lock
	 * mode.
	 *
	 * @param key      the key of the entity to find
	 * @param lockMode the lock mode to use
	 * @return the found entity
	 */
	public Optional<E> findSingleEntity(ID key, LockModeType lockMode);
	
	/**
	  * This method is used to find a list of entities in the repository.
	  *
	  * @return the list of found entities
	  */
	public List<E> findListEntity();
	
	/**
	 * This method is used to find a list of entities in the repository with a lock
	 * mode.
	 *
	 * @param lockMode the lock mode to use
	 * @return the list of found entities
	 */
	public List<E> findListEntity(LockModeType lockMode);
	
	/**
	 * This method is used to find a single reference of an entity in the repository.
	 *
	 * @param key the key of the entity to find
	 * @return the found entity reference
	 */
	public E findSingleReference(ID key);
	
	/**
	 * This method is used to get the count of entities in the repository.
	 *
	 * @return the count of entities
	 */
	public Long getCount();
	
	/**
	  * This method is used to save an entity in the repository.
	  *
	  * @param entity the entity to save
	  */
	public void save(E entity);
	
	 /**
	  * This method is used to save a list of entities in the repository.
	  *
	  * @param entities the list of entities to save
	  */
	public void saveAll(List<E> entities);
	
	/**
	 * This method is used to update an entity in the repository.
	 *
	 * @param entity the entity to update
	 */
	public void makePersistent(E entity);
	
	/**
	 * This method is used to update a list of entities in the repository.
	 *
	 * @param entities the list of entities to update
	 */
	public void makePersistentAll(List<E> entities);
	
	/**
	 * This method is used to delete an entity from the repository.
	 *
	 * @param entity the entity to delete
	 */
	public void makeTransient(E entity);
	
	/**
	 * This method is used to delete a list of entities from the repository.
	 *
	 * @param entities the list of entities to delete
	 */
	public void makeTransientAll(List<E> entities);
	
	/**
	 * This method is used to check the version of an entity.
	 *
	 * @param entity      the entity to check
	 * @param forceUpdate whether to force an update
	 */
	public void checkVersion(E entity, boolean forceUpdate);
}
