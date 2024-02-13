package edu.unc.academico.controllers;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> listarDptos() {
        return departamentoService.getAllDepartamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorDpto(@PathVariable Long id) {
        Optional<Departamento> dptoOptional = departamentoService.getDepartamentoById(id);
        if (dptoOptional.isPresent()){
            return ResponseEntity.ok(dptoOptional.get());
        }

        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Departamento dpto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departamentoService.saveDepartamento(dpto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Departamento dpto) {
        Optional<Departamento> departamento = departamentoService.getDepartamentoById(id);
        if (departamento.isPresent()){
            Departamento dptoDB = departamento.get();
            dptoDB.setNombreDpto(dpto.getNombreDpto());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(departamentoService.saveDepartamento(dptoDB));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.getDepartamentoById(id);
        if (departamento.isPresent()){
            departamentoService.deleteDepartamentoById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
