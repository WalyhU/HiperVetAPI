package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_diagnostico", nullable = false)
    private Short id;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

}