package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_servicio", nullable = false)
    private Short id;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

    @Column(name = "tipo")
    private Short tipo;

    @Column(name = "precio", precision = 12, scale = 2)
    private BigDecimal precio;

}