package edu.unc.academico.services;

import edu.unc.academico.domain.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {
    List<Departamento> getAllDepartamentos();
    Optional<Departamento> getDepartamentoById(Long id);
    Departamento saveDepartamento(Departamento departamento);
    void deleteDepartamentoById(Long id);
}
