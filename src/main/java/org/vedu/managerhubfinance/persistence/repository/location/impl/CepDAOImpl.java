package org.vedu.managerhubfinance.persistence.repository.base.impl;

import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.CepDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class CepDAOImpl extends CrudRepositoryImpl<String, Cep> implements CepDAO<String, Cep> {

	public CepDAOImpl() {
		super(Cep.class);
	}

	@Override
	public List<Cep> findAll(boolean withCity) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cep> cq = cb.createQuery(Cep.class);
		Root<Cep> root = cq.from(Cep.class);
		cq.select(root);
		if (withCity)
			root.fetch("city");
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public List<Cep> findByName(String name, boolean subtring) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cep> cq = cb.createQuery(Cep.class);
		Root<Cep> root = cq.from(Cep.class);
		cq.select(root);
		if (subtring)
			cq.where(cb.like(root.get("name"), "%" + name + "%"));
		else
			cq.where(cb.equal(root.get("name"), name));
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void makeTransientById(String cep) {
		getEntityManager()
		.createQuery("delete from Cep c where c.cep = :cep")
		.setParameter("cep", cep)
		.executeUpdate();
	}

	@Override
	public Optional<Cep> findByStreet(String street) {
	    TypedQuery<Cep> q = 
	    		getEntityManager()
	            .createQuery(
	                    "select c from Cep c where c.street = :street",
	                    Cep.class);
	    Optional<Cep> result = 
	            Optional.ofNullable(q
	                    .setParameter("street", street)
	                    .getSingleResult());
	    return result;
	}
}
