package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @Column(name = "CodigoCliente", nullable = false, length = 10)
    private String codigoCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CodigoPersona", nullable = false)
    private Persona codigoPersona;

}