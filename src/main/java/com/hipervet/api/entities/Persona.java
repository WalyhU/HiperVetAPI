package com.hipervet.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @Column(name = "CodigoPersona", nullable = false)
    private Integer id;

    @Column(name = "PrimerNombre", length = 128)
    private String primerNombre;

    @Column(name = "SegundoNombre", length = 128)
    private String segundoNombre;

    @Column(name = "TercerNombre", length = 128)
    private String tercerNombre;

    @Column(name = "PrimerApellido", nullable = false, length = 128)
    private String primerApellido;

    @Column(name = "SegundoApellido", length = 128)
    private String segundoApellido;

    @Column(name = "TercerApellido", length = 128)
    private String tercerApellido;

    @Column(name = "TipoPersona", nullable = false)
    private Character tipoPersona;

    @Column(name = "RazonSocial", length = 256)
    private String razonSocial;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

}