package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefono_persona")
public class TelefonoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_telefono_persona")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "correlativo_telefono", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Telefono correlativoTelefono;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigo_persona", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona codigoPersona;
}