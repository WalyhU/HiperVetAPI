package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_sucursal", nullable = false)
    private Short id;

    @Column(name = "nombre_sucursal", nullable = false, length = 128)
    private String nombreSucursal;

    @Column(name = "direccion", nullable = false, length = 256)
    private String direccion;

}