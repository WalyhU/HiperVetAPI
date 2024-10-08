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
    @Column(name = "codigo_detalle_diagnostico", nullable = false)
    private Integer codigoDetalleDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private DetalleCita detalleCita;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_diagnostico", nullable = false)
    private Diagnostico codigoDiagnostico;

}