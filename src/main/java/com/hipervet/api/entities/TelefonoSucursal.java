package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefono_sucursal")
public class TelefonoSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_telefono_sucursal", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "correlativo_telefono", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Telefono correlativoTelefono;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_sucursal", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sucursal codigoSucursal;

}