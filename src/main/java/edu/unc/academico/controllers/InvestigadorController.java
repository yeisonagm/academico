package edu.unc.academico.controllers;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.services.InvestigadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/investigadores")
public class InvestigadorController {
    @Autowired
    private InvestigadorService investigadorService;

    @GetMapping
    public List<Investigador> listar() {
        return investigadorService.getAllInvestigadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorInv(@PathVariable Long id) {
        Optional<Investigador> invOptional = investigadorService.getInvestigadorById(id);
        if (invOptional.isPresent()){
            return ResponseEntity.ok(invOptional.get());
        }

        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Investigador inv) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(investigadorService.saveInvestigador(inv));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Investigador inv) {
        Optional<Investigador> investigador = investigadorService.getInvestigadorById(id);
        if (investigador.isPresent()){
            Investigador invDB = investigador.get();
            invDB.setEmail(inv.getEmail());
            invDB.setNombres(inv.getNombres());
            invDB.setApePat(inv.getApePat());
            invDB.setApeMat(inv.getApeMat());
            invDB.setFehaNac(inv.getFehaNac());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(investigadorService.saveInvestigador(invDB));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Investigador> investigador = investigadorService.getInvestigadorById(id);
        if (investigador.isPresent()){
            investigadorService.deleteInvestigadorById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
