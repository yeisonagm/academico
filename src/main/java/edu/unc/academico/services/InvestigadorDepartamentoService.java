package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;

public interface InvestigadorDepartamentoService {
    Investigador replaceDpto(Long idInvestigador, Long idDepartamento);
    void removeDpto(Long idInvestigador);
}
