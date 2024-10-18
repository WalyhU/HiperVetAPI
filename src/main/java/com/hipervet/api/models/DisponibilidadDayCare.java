package com.hipervet.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadDayCare {
    private Instant fecha;
    private Integer tallaPerro;
    private Long espaciosOcupados;
}