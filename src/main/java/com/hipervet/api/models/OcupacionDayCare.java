package com.hipervet.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OcupacionDayCare {
    private Instant fecha;
    private Integer cantidad;
    private Long espaciosOcupados;
}