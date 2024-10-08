package com.hipervet.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @Column(name = "CodigoServicio", nullable = false)
    private Short id;

    @Column(name = "Descripcion", length = 256)
    private String descripcion;

    @Column(name = "Tipo")
    private Short tipo;

    @Column(name = "Precio", precision = 12, scale = 2)
    private BigDecimal precio;

}