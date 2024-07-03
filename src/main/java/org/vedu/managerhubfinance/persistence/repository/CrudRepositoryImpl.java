package org.vedu.managerhubfinance.persistence.repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;

/**
 * @deprecated Desde a versão 1.0. Use {@link jakarta.data.repository.CrudRepository}. Esta interface será removida em uma versão futura.
 */
@Deprecated(since = "1.0", forRemoval = true)
public abstract class CrudRepositoryImpl<ID, E> implements CrudRepository<ID, E> {

	@PersistenceContext
	private EntityManager entityManager;
	
	protected final Class<E> entityClass;
	
	protected CrudRepositoryImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Optional<E> findSingleEntity(ID key) {
		entityManager.setFlushMode(FlushModeType.AUTO);
		return Optional.ofNullable(entityManager.find(entityClass, key, LockModeType.NONE));
	}

	@Override
	public Optional<E> findSingleEntity(ID key, LockModeType lockMode) {
		entityManager.setFlushMode(FlushModeType.AUTO);
		return Optional.ofNullable(entityManager.find(entityClass, key, lockMode));
	}

	@Override
	public List<E> findListEntity() {
		return entityManager
				.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass)
				.setLockMode(LockModeType.NONE)
				.setFlushMode(FlushModeType.AUTO)
				.getResultList();
	}
	
	@Override
	public List<E> findListEntity(LockModeType lockMode) {
		return entityManager
				.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass)
				.setLockMode(lockMode)
				.setFlushMode(FlushModeType.AUTO)
				.getResultList();
	}

	@Override
	public E findSingleReference(ID key) {
		return entityManager.getReference(entityClass, key);
	}
	
	public Long getCount() {
		CriteriaQuery<Long> c = entityManager.getCriteriaBuilder().createQuery(Long.class);
		c.select(entityManager.getCriteriaBuilder().count(c.from(entityClass)));
		return entityManager.createQuery(c).getSingleResult();
	}

	@Override
	public void save(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public void saveAll(List<E> entities) {
		entities.forEach(entityManager::persist);
	}

	@Override
	public void makePersistent(E entity) {
		entityManager.merge(entity);
	}

	@Override
	public void makePersistentAll(List<E> entities) {
		entities.forEach(entityManager::merge);
	}

	@Override
	public void makeTransient(E entity) {
		entityManager.remove(entity);
	}

	@Override
	public void makeTransientAll(List<E> entities) {
		entities.forEach(entityManager::remove);
	}

	@Override
	public void checkVersion(E entity, boolean forceUpdate) {
		entityManager.lock(entity, 
				forceUpdate ? LockModeType.OPTIMISTIC_FORCE_INCREMENT :
				LockModeType.OPTIMISTIC);
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
