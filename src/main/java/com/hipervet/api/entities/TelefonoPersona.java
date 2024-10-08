package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TelefonoPersona")
public class TelefonoPersona {
    @EmbeddedId
    private TelefonoPersonaId id;

    @MapsId("correlativoTelefono")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CorrelativoTelefono", nullable = false)
    private Telefono correlativoTelefono;

    @MapsId("codigoPersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CodigoPersona", nullable = false)
    private Persona codigoPersona;

}