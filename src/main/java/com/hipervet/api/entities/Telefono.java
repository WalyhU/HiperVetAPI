package com.hipervet.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Telefono")
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    @Id
    @Column(name = "CorrelativoTelefono", nullable = false)
    private Integer id;

    @Column(name = "NumeroTelefono", length = 15)
    private String numeroTelefono;
}