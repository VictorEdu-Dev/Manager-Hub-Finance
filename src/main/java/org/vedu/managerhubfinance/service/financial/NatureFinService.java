package org.vedu.managerhubfinance.service.finance;

import java.util.Set;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFin;
import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFinEnum;

import jakarta.ejb.Local;

@Local
public interface NatureFinService {
	public void deleteNatureFin(FinNatureFin natureFin);
	
	public FinNatureFin getNatureFinByType(FinNatureFinEnum natureFin);

	public FinNatureFin getNatureFin(Long id);

	public Set<FinNatureFin> getNatureFins();

	public void saveNatureFin(FinNatureFin natureFin);

	public void updateNatureFin(FinNatureFin natureFin);
}
