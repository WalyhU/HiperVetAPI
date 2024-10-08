package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @Column(name = "CodigoEmpleado", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CodigoPersona", nullable = false)
    private Persona codigoPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoPuesto")
    private Puesto codigoPuesto;

}