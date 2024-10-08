package com.hipervet.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "DetalleCita")
public class DetalleCita {
    @EmbeddedId
    private DetalleCitaId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cita cita;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NumeroFicha", nullable = false, insertable=false, updatable=false)
    private FichaMascota numeroFicha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoServicio")
    private Servicio codigoServicio;

    @Column(name = "Inicio")
    private Instant inicio;

    @Column(name = "Fin")
    private Instant fin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodigoEmpleado")
    private Empleado codigoEmpleado;

}