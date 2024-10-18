package com.hipervet.api.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteVentas {
    private String nombreServicio;
    private Long cantidad;
    private BigDecimal totalVentas;
}
