package edu.unc.academico.services;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.domain.Investigador;
import edu.unc.academico.repository.DepartamentoRepository;
import edu.unc.academico.repository.InvestigadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InvestigadorDepartamentoServiceImp implements InvestigadorDepartamentoService {
    @Autowired
    private InvestigadorRepository invRepository;
    @Autowired
    private DepartamentoRepository dptoRepository;

    @Override
    @Transactional
    public Investigador replaceDpto(Long idInvestigador, Long idDepartamento) {
        Optional<Investigador> investigador = invRepository.findById(idInvestigador);
        Optional<Departamento> departamento = dptoRepository.findById(idDepartamento);

        investigador.get().setDepartamento(departamento.get());
        return investigador.get();
    }

    @Override
    public void removeDpto(Long idInvestigador) {
        Optional<Investigador> investigador = invRepository.findById(idInvestigador);
        Optional<Departamento> departamento = dptoRepository
                .findById(investigador.get().getDepartamento().getIdDpto());
        departamento.ifPresent(dpto -> dpto.getInvestigadores().remove(investigador.get()));
        investigador.get().setDepartamento(null);
    }
}
