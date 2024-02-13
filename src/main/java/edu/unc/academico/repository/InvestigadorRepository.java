package edu.unc.academico.repository;

import edu.unc.academico.domain.Investigador;
import org.springframework.data.repository.CrudRepository;

public interface InvestigadorRepository extends CrudRepository<Investigador, Long>{
}