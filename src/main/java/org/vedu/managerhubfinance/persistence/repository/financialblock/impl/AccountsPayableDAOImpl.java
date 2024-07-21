package org.vedu.managerhubfinance.persistence.repository.financialblock.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinPaymentLaunch;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.financialblock.FinPaymentLaunchDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class FinPaymentLaunchDAOImpl extends CrudRepositoryImpl<Long, FinPaymentLaunch> implements FinPaymentLaunchDAO {

	private static final Logger logger = Logger.getLogger(FinPaymentLaunchDAOImpl.class.getName());
	
	public FinPaymentLaunchDAOImpl() {
        super(FinPaymentLaunch.class);
    }
	
	@Override
	public FinPaymentLaunch findBySourceDocumentsId(String sourceDocumentsId) {
		TypedQuery<FinPaymentLaunch> query = getEntityManager()
				.createQuery(
						"SELECT e FROM " + entityClass.getName() + 
						" e WHERE e.sourceDocuments.id = :sourceDocumentsId",
						entityClass)
				.setParameter("sourceDocumentsId", sourceDocumentsId);
		return query.getSingleResult();
	}

	@Override
	public Set<FinPaymentLaunch> listAccountPayable(Map<String, Object> filters) {
		logger.log(Level.WARNING, "Method not implemented filters: {0}", filters);
		
		Set<FinPaymentLaunch> result = null;
		TypedQuery<FinPaymentLaunch> query = getEntityManager()
				.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass);
		List<FinPaymentLaunch> list = query.getResultList();
		if (list != null && !list.isEmpty()) {
			result = new HashSet<>(list);
		}
		return result;
	}	
}
