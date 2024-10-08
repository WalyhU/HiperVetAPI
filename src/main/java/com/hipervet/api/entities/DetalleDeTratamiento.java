package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "detalle_de_tratamiento")
public class DetalleDeTratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_tratamiento", nullable = false)
    private Integer codigoDetalleTratamiento;

    @Column(name = "correlativo", nullable = false)
    private Integer correlativo;

    @Column(name = "numero_cita", nullable = false)
    private Integer numeroCita;

    @Column(name = "numero_ficha", nullable = false)
    private Integer numeroFicha;

    @Column(name = "codigo_sucursal", nullable = false)
    private Short codigoSucursal;

    @ManyToOne
    @JoinColumn(name = "codigo_tratamiento")
    private Tratamiento codigoTratamiento;

    @ManyToOne
    @JoinColumn(name = "codigo_diagnostico")
    private DetalleDiagnostico codigoDiagnostico;
}