package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity(name = "cita")
public class Cita {
    @Id
    @Column(name = "numero_cita", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_sucursal")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sucursal codigoSucursal;

    private Instant fechaCita;

    @Column(length = 512)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_empleado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empleado codigoEmpleado;

    private Character tipoCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente codigoCliente;

}