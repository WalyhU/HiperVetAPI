package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TelefonoSucursal")
public class TelefonoSucursal {
    @EmbeddedId
    private TelefonoSucursalId id;

    @MapsId("correlativoTelefono")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CorrelativoTelefono", nullable = false)
    private Telefono correlativoTelefono;

    @MapsId("codigoSucursal")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CodigoSucursal", nullable = false)
    private Sucursal codigoSucursal;

}