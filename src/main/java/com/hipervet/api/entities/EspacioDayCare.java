package com.hipervet.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EspacioDayCare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tallaPerro;
    private Integer espaciosTotales;
    private Integer espaciosOcupados;
}
