package com.hipervet.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEficiente {
    private String codigoEmpleado;
    private String primerNombre;
    private String primerApellido;
    private Long minutosTotales;
}
