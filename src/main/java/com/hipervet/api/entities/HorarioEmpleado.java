package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class HorarioEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "correlativo_horario")
    private Long correlativoHorario;

    @ManyToOne
    @JoinColumn(name = "codigo_empleado")
    private Empleado empleado;

    private Instant fecha;
    private Instant entrada;
    private Instant salida;
    private Instant entradaAlmuerzo;
    private Instant salidaAlmuerzo;
}
