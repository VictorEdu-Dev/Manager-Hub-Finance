package org.vedu.managerhubfinance.persistence.repository.location;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;

import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

@Repository
public interface CepDataStore extends BasicRepository<Cep, String> {
}
