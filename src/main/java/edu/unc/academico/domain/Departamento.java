package edu.unc.academico.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDpto;
    @Column(unique = true)
    private String nombreDpto;

    @OneToMany(mappedBy = "departamento")
    private List<Investigador> investigadores = new ArrayList<>();
}
