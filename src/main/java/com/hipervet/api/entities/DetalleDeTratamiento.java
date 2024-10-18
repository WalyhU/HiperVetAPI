package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JoinColumn(name = "correlativo")
    private DetalleCita correlativo;

    @ManyToOne
    @JoinColumn(name = "numero_cita")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cita numeroCita;

    @ManyToOne
    @JoinColumn(name = "numero_ficha")
    private FichaMascota numeroFicha;

    @ManyToOne
    @JoinColumn(name = "codigo_sucursal")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sucursal codigoSucursal;

    @ManyToOne
    @JoinColumn(name = "codigo_tratamiento")
    private Tratamiento codigoTratamiento;

    @ManyToOne
    @JoinColumn(name = "codigo_diagnostico")
    private DetalleDiagnostico codigoDiagnostico;
}