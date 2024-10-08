package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity(name = "cita")
public class Cita {
    @EmbeddedId
    private CitaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_sucursal", nullable = false, insertable=false, updatable=false)
    private Sucursal codigoSucursal;

    private Instant fechaCita;

    @Column(length = 512)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_empleado")
    private Empleado codigoEmpleado;

    private Character tipoCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cliente")
    private Cliente codigoCliente;

}