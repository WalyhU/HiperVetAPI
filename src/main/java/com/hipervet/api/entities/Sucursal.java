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
@Table(name = "Sucursal")
public class Sucursal {
    @Id
    @Column(name = "CodigoSucursal", nullable = false)
    private Short id;

    @Column(name = "NombreSucursal", nullable = false, length = 128)
    private String nombreSucursal;

    @Column(name = "Direccion", nullable = false, length = 256)
    private String direccion;

}