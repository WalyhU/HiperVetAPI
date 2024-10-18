package com.hipervet.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "detalle_cita")
public class DetalleCita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cita cita;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "numero_ficha")
    private FichaMascota numeroFicha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_servicio")
    private Servicio codigoServicio;

    @Column(name = "inicio")
    private Instant inicio;

    @Column(name = "fin")
    private Instant fin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado")
    private Empleado codigoEmpleado;

}
