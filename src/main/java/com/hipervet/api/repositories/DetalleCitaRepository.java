package com.hipervet.api.repositories;

import com.hipervet.api.entities.*;
import com.hipervet.api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.time.Instant;
import java.util.List;

public interface DetalleCitaRepository extends JpaRepository<DetalleCita, Integer> {
    public List<DetalleCita> findDetalleCitasByCita(Cita cita);
    public DetalleCita findDetalleCitaByCitaId(String citaId);
    public List<DetalleCita> findDetalleCitasByCodigoServicio(Servicio servicio);
    public List<DetalleCita> findDetalleCitasByCodigoEmpleado(Empleado codigoEmpleado);
    public List<DetalleCita> findDetalleCitasByInicioBetween(Instant inicio, Instant inicio2);
    @Query("SELECT new com.hipervet.api.models.EmpleadoEficiente(e.id, p.primerNombre, p.primerApellido, SUM(TIMESTAMPDIFF(MINUTE, dc.inicio, dc.fin))) " +
            "FROM DetalleCita dc " +
            "JOIN dc.cita c " +
            "JOIN dc.codigoServicio s " +
            "JOIN c.codigoEmpleado e " +
            "JOIN e.codigoPersona p " +
            "WHERE e.codigoPuesto.descripcion = 'Groomista' " +
            "GROUP BY e.id, p.primerNombre, p.primerApellido " +
            "ORDER BY SUM(TIMESTAMPDIFF(MINUTE, dc.inicio, dc.fin)) ASC")
    public List<EmpleadoEficiente> findEmpleadoMasEficiente();
    @Query("SELECT new com.hipervet.api.models.MedicoVeterinarioEficiente(e.id, p.primerNombre, p.primerApellido, COUNT(c.id)) " +
            "FROM DetalleCita dc " +
            "JOIN dc.cita c " +
            "JOIN c.codigoEmpleado e " +
            "JOIN e.codigoPersona p " +
            "WHERE e.codigoPuesto.descripcion = 'Médico Veterinario' " +
            "GROUP BY e.id, p.primerNombre, p.primerApellido " +
            "ORDER BY COUNT(c.id) DESC")
    List<MedicoVeterinarioEficiente> findMedicoVeterinarioMasPacientes();
    @Query("SELECT new com.hipervet.api.models.ReporteVentas(s.descripcion, COUNT(dc.id), SUM(s.precio)) " +
            "FROM DetalleCita dc " +
            "JOIN dc.codigoServicio s " +
            "WHERE dc.inicio BETWEEN :desde AND :hasta " +
            "GROUP BY s.descripcion " +
            "ORDER BY SUM(s.precio) DESC")
    public List<ReporteVentas> findReporteVentas(Instant desde, Instant hasta);
    @Query("SELECT new com.hipervet.api.models.EmpleadoEficiente(e.id, p.primerNombre, p.primerApellido, SUM(TIMESTAMPDIFF(MINUTE, dc.inicio, dc.fin))) " +
            "FROM DetalleCita dc " +
            "JOIN dc.cita c " +
            "JOIN c.codigoEmpleado e " +
            "JOIN e.codigoPersona p " +
            "WHERE dc.inicio BETWEEN :desde AND :hasta " +
            "GROUP BY e.id, p.primerNombre, p.primerApellido " +
            "ORDER BY SUM(TIMESTAMPDIFF(MINUTE, dc.inicio, dc.fin)) ASC")
    List<EmpleadoEficiente> findEmpleadoMenosTrabajo(Instant desde, Instant hasta);
    @Query("SELECT new com.hipervet.api.models.ReporteVentas(s.descripcion, COUNT(dc.id), SUM(s.precio)) " +
            "FROM DetalleCita dc " +
            "JOIN dc.codigoServicio s " +
            "WHERE dc.inicio BETWEEN :desde AND :hasta " +
            "GROUP BY s.descripcion " +
            "ORDER BY COUNT(dc.id) DESC")
    List<ReporteVentas> findServicioMasVendido(Instant desde, Instant hasta);
    @Query("SELECT new com.hipervet.api.models.OcupacionDayCare(dc.inicio, ed.espaciosTotales, SUM(ed.espaciosOcupados)) " +
            "FROM DetalleCita dc " +
            "JOIN EspacioDayCare ed ON dc.codigoServicio.id = ed.id " +
            "WHERE dc.inicio BETWEEN :desde AND :hasta " +
            "GROUP BY dc.inicio, ed.espaciosTotales " +
            "ORDER BY dc.inicio ASC")
    List<OcupacionDayCare> findOcupacionDayCare(Instant desde, Instant hasta);
    @Query("SELECT new com.hipervet.api.models.DisponibilidadDayCare(dc.inicio, ed.espaciosTotales, SUM(ed.espaciosOcupados)) " +
            "FROM DetalleCita dc " +
            "JOIN EspacioDayCare ed ON dc.codigoServicio.id = ed.id " +
            "WHERE dc.inicio = :fecha AND ed.tallaPerro = :tallaPerro " +
            "GROUP BY dc.inicio, ed.espaciosTotales")
    List<DisponibilidadDayCare> findDisponibilidadByFechaAndTallaPerro(Instant fecha, String tallaPerro);
}

