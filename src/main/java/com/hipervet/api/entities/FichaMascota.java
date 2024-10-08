package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "FichaMascota")
public class FichaMascota {
    @Id
    @Column(name = "NumeroFicha", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoEspecie")
    private Especie codigoEspecie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoRaza")
    private Raza codigoRaza;

    @Column(name = "Nombre", length = 64)
    private String nombre;

    @Column(name = "FechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "Talla")
    private Short talla;

}