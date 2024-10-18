package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_persona")
    private Integer id;

    @Column(name = "primer_nombre", length = 128)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 128)
    private String segundoNombre;

    @Column(name = "tercer_nombre", length = 128)
    private String tercerNombre;

    @Column(name = "primer_apellido", nullable = false, length = 128)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 128)
    private String segundoApellido;

    @Column(name = "tercer_apellido", length = 128)
    private String tercerApellido;

    @Column(name = "tipo_persona", nullable = false)
    private Character tipoPersona;

    @Column(name = "razon_social", length = 256)
    private String razonSocial;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

}