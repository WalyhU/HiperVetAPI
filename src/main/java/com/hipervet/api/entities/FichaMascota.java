package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ficha_mascota")
public class FichaMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_ficha", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_especie")
    private Especie codigoEspecie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_raza")
    private Raza codigoRaza;

    @Column(name = "nombre", length = 64)
    private String nombre;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "talla")
    private Short talla;

}