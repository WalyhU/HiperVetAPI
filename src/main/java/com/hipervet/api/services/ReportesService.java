package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.models.*;

import java.time.Instant;
import java.time.Instant;
import java.util.List;

public interface ReportesService {
    //    public List<DetalleCita> getDetalleCitaByNumeroCita(String numeroCita);
//    public List<DetalleCita> getDetalleCitaByPeriodo(String fechaInicio, String fechaFin);
//    public Empleado getGroomistaEficiente();
//    public Empleado getVeterinarioMasPacientes();
//    public List<Ventas> getVentasByPeriodo(String fechaInicio, String fechaFin);
//    public Empleado getEmpleadoMenosTrabajoByPeriodo(String fechaInicio, String fechaFin);
//    public Servicio getServicioMasSolicitadoByPeriodo(String fechaInicio, String fechaFin);
    DetalleCita obtenerReporteCita(String numeroCita);
    List<DetalleCita> obtenerCitasPorPeriodo(Instant desde, Instant hasta);
    List<EmpleadoEficiente> obtenerGroomistaMasEficiente();
    List<MedicoVeterinarioEficiente> obtenerVeterinarioMasEficiente();
    List<ReporteVentas> obtenerReporteVentas(Instant desde, Instant hasta);
    EmpleadoEficiente obtenerEmpleadoMenosTrabajo(Instant desde, Instant hasta);
    ReporteVentas obtenerServicioMasVendido(Instant desde, Instant hasta);
    List<OcupacionDayCare> obtenerOcupacionDayCare(Instant desde, Instant hasta);
    List<DisponibilidadDayCare> obtenerDisponibilidadDayCare(Instant fecha, String tallaPerro);
    List<EmpleadoFaltas> obtenerEmpleadoMasFaltas(Integer mes, Integer anio);
}
