package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefono")
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "correlativo_telefono", nullable = false)
    private Integer id;

    @Column(name = "numero_telefono", length = 15)
    private String numeroTelefono;
}