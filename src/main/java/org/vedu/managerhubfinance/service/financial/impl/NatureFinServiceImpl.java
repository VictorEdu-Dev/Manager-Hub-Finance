package org.vedu.managerhubfinance.service.finance.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFin;
import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFinEnum;
import org.vedu.managerhubfinance.persistence.repository.financialblock.NatureFinDAO;
import org.vedu.managerhubfinance.service.finance.NatureFinService;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class NatureFinServiceImpl implements NatureFinService {
	
	private Logger logger = Logger.getLogger(NatureFinServiceImpl.class.getName());
	
	@EJB
	private NatureFinDAO natureFinDAO;

	@Override
	public void deleteNatureFin(FinNatureFin finNatureFin) {
		if (finNatureFin.getId() != null) {
			natureFinDAO.makeTransient(finNatureFin);
		} else {
			logger.warning("NatureFin is null");
		}
	}

	@Override
	public FinNatureFin getNatureFinByType(FinNatureFinEnum natureFin) {
		return natureFinDAO.getNatureFinByType(natureFin);
	}

	@Override
	public FinNatureFin getNatureFin(Long id) {
		Optional<FinNatureFin> natureFin = natureFinDAO.findSingleEntity(id);
		if (!natureFin.isPresent()) {
            logger.warning("NatureFin not found");
		} else {
			return natureFin.get();
		}
		logger.warning("NatureFin is null");
		return null;
	}

	@Override
	public Set<FinNatureFin> getNatureFins() {
		List<FinNatureFin> natureFins = natureFinDAO.findListEntity();
		if (natureFins.isEmpty()) {
			logger.warning("NatureFins not found");
		} else {
			return Set.copyOf(natureFins);
		}
		logger.warning("NatureFins is null");
		return null;
	}

	@Override
	public void saveNatureFin(FinNatureFin natureFinDTO) {
		if (natureFinDTO != null) {
			natureFinDAO.save(natureFinDTO);
		} else {
			logger.warning("NatureFin is null");
		}
	}

	@Override
	public void updateNatureFin(FinNatureFin natureFinDTO) {
		if (natureFinDTO.getId() != null) {
			natureFinDAO.makePersistent(natureFinDTO);
		} else {
			logger.warning("NatureFin is null");
		}
	}

}
