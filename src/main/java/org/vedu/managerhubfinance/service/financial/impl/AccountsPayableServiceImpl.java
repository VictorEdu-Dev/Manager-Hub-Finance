package org.vedu.managerhubfinance.service.finance.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinPaymentLaunch;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.financialblock.FinPaymentLaunchDAO;
import org.vedu.managerhubfinance.service.finance.PaymentLaunchService;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.LockModeType;

@Stateless
public class PaymentLaunchServiceImpl extends CrudRepositoryImpl<String, FinPaymentLaunch> implements PaymentLaunchService<String, FinPaymentLaunch> {

    private static final Logger logger = Logger.getLogger(PaymentLaunchServiceImpl.class.getName());

    @EJB
    private FinPaymentLaunchDAO finPaymentLaunch;

    public PaymentLaunchServiceImpl() {
        super(FinPaymentLaunch.class);
    }

    @Override
    public void registerAccountPayable(FinPaymentLaunch entity) {
        try {
        	if (entity != null && entity.getId() == null)
        		finPaymentLaunch.save(entity);
        	else
        		logger.log(Level.SEVERE, "Error registering account payable: Entity is null or already registered");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error registering account payable: {0}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateAccountPayable(FinPaymentLaunch entity) {
        try {
        	if (entity != null && entity.getId() != null)
        		finPaymentLaunch.makePersistent(entity);
        	else
        		logger.log(Level.SEVERE, "Error updating account payable: Entity is null");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error updating account payable: {0}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteAccountPayable(FinPaymentLaunch entity) {
        try {
        	if (entity != null && entity.getId() != null)
        		finPaymentLaunch.makeTransient(entity);
        	else
        		logger.log(Level.SEVERE, "Error deleting account payable: Entity is null");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting account payable: {0}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<FinPaymentLaunch> listAccountPayable() {
        try {
            return finPaymentLaunch.findListEntity(LockModeType.PESSIMISTIC_READ);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error listing accounts payable: {0}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Set<FinPaymentLaunch> listAccountPayable(Map<String, Object> filters) {
		try {
			if (filters == null || filters.isEmpty())
				return finPaymentLaunch.listAccountPayable(filters);
			else
				return finPaymentLaunch.listAccountPayable(filters);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error listing accounts payable: {0}", e.getMessage());
			throw e;
		}
    }

    @Override
    public FinPaymentLaunch findBySourceDocumentsId(String sourceDocumentsId) {
        try {
            return finPaymentLaunch.findBySourceDocumentsId(sourceDocumentsId);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding account payable by source document ID: {0}", sourceDocumentsId);
            return null;
        }
    }

}
