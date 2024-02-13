package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;

import java.util.List;
import java.util.Optional;

public interface InvestigadorService {
    List<Investigador> getAllInvestigadores();
    Optional<Investigador> getInvestigadorById(Long id);
    Investigador saveInvestigador(Investigador investigador);
    void deleteInvestigadorById(Long id);
}
