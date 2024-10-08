package com.hipervet.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Puesto")
public class Puesto {
    @Id
    @Column(name = "CodigoPuesto", nullable = false)
    private Short id;

    @Column(name = "Descripcion", length = 256)
    private String descripcion;

}