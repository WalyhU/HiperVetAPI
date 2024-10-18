package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @Column(name = "codigo_empleado", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigo_persona", nullable = false)
    private Persona codigoPersona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_puesto")
    private Puesto codigoPuesto;

}