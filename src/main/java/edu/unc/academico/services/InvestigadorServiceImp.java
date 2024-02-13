package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.repository.InvestigadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class InvestigadorServiceImp implements InvestigadorService{
    @Autowired // Injeccion de dependencias
    private InvestigadorRepository investigadorRepository;
    @Override
    public List<Investigador> getAllInvestigadores() {
        return (List<Investigador>) investigadorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Investigador> getInvestigadorById(Long id) {
        return investigadorRepository.findById(id);
    }

    @Override
    public Investigador saveInvestigador(Investigador investigador) {
        return investigadorRepository.save(investigador);
    }

    @Override
    public void deleteInvestigadorById(Long id) {
        investigadorRepository.deleteById(id);
    }
}
