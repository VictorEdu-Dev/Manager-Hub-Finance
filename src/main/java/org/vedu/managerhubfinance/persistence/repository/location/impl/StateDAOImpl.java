package org.vedu.managerhubfinance.persistence.repository.base.impl;

import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.groupbasic.State;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.StateDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.LockModeType;
import jakarta.persistence.TypedQuery;

@Stateless
public class StateDAOImpl extends CrudRepositoryImpl<String, State> implements StateDAO<String, State> {
	
	public StateDAOImpl() {
		super(State.class);
	}

	@Override
	public Optional<State> findByName(String name) {
		TypedQuery<State> query = getEntityManager()
				.createQuery("SELECT s FROM State s WHERE s.name = :name",
				State.class);
		query.setParameter("name", name);
		return query.getResultStream().findFirst();
	}

	@Override
	public State findByName(String name, LockModeType lockModeType) {
		TypedQuery<State> query =
				getEntityManager()
				.createQuery(
						"SELECT s FROM State s WHERE s.name = :name",
						State.class);
		query.setParameter("name", name);
		query.setLockMode(lockModeType);
		return query.getSingleResult();
	}
}
