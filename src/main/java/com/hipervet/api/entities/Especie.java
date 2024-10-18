package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Especie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_especie", nullable = false)
    private Short id;

    @Column(name = "descripcion", length = 256)
    private String descripcion;

}
