package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_diagnostico")
public class DetalleDiagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_diagnostico")
    private Integer codigoDetalleDiagnostico;

    @ManyToOne(fetch = FetchType.EAGER)
    private DetalleCita detalleCita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_diagnostico")
    private Diagnostico codigoDiagnostico;

}