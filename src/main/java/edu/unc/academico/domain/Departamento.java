package edu.unc.academico.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Investigador> investigadores = new ArrayList<>();
}
