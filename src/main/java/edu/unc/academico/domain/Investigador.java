package edu.unc.academico.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Investigador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iDInvestigador;

    @Column(unique = true)
    private String email;
    private String nombres;
    private String apePat;
    private String apeMat;

    @Temporal(TemporalType.DATE)
    private Date fehaNac;

    @ManyToOne
    @JsonBackReference
    private Departamento departamento;
}
