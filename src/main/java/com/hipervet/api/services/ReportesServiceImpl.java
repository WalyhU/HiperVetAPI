package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.models.*;
import com.hipervet.api.repositories.DetalleCitaRepository;
import com.hipervet.api.repositories.HorarioEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportesServiceImpl implements ReportesService {

    @Autowired
    private DetalleCitaRepository detalleCitaRepository;
    @Autowired
    private HorarioEmpleadoRepository horarioEmpleadoRepository;

    @Override
    public DetalleCita obtenerReporteCita(String numeroCita) {
        return detalleCitaRepository.findDetalleCitaByCitaId(numeroCita);
    }

    @Override
    public List<DetalleCita> obtenerCitasPorPeriodo(Instant desde, Instant hasta) {
        // Implementar lógica para obtener citas en un periodo
        return detalleCitaRepository.findDetalleCitasByInicioBetween(desde, hasta);
    }

    @Override
    public List<EmpleadoEficiente> obtenerGroomistaMasEficiente() {
        return detalleCitaRepository.findEmpleadoMasEficiente();
    }

    @Override
    public List<MedicoVeterinarioEficiente> obtenerVeterinarioMasEficiente() {
        // Implementar lógica para obtener el veterinario más eficiente
        return detalleCitaRepository.findMedicoVeterinarioMasPacientes();
    }

    @Override
    public List<ReporteVentas> obtenerReporteVentas(Instant desde, Instant hasta) {
        // Implementar lógica para obtener reporte de ventas
        return detalleCitaRepository.findReporteVentas(desde, hasta);
    }

    @Override
    public EmpleadoEficiente obtenerEmpleadoMenosTrabajo(Instant desde, Instant hasta) {
        List<EmpleadoEficiente> empleados = detalleCitaRepository.findEmpleadoMenosTrabajo(desde, hasta);
        return empleados.isEmpty() ? null : empleados.getFirst();
    }

    @Override
    public ReporteVentas obtenerServicioMasVendido(Instant desde, Instant hasta) {
        // Implementar lógica para obtener el servicio más vendido
        List<ReporteVentas> servicios = detalleCitaRepository.findServicioMasVendido(desde, hasta);
        return servicios.isEmpty() ? null : servicios.getFirst();
    }

    @Override
    public List<OcupacionDayCare> obtenerOcupacionDayCare(Instant desde, Instant hasta) {
        // Implementar lógica para obtener ocupación del day care
        return detalleCitaRepository.findOcupacionDayCare(desde, hasta);
    }

    @Override
    public List<DisponibilidadDayCare> obtenerDisponibilidadDayCare(Instant fecha, String tallaPerro) {
        // Implementar lógica para obtener disponibilidad del day care
        return detalleCitaRepository.findDisponibilidadByFechaAndTallaPerro(fecha, tallaPerro);
    }

    @Override
    public List<EmpleadoFaltas> obtenerEmpleadoMasFaltas(Integer mes, Integer anio) {
        // Implementar lógica para obtener el empleado con más faltas
        return horarioEmpleadoRepository.findEmpleadoMasFaltas(mes, anio);
    }
}