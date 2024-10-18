package com.hipervet.api.controllers;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.models.*;
import com.hipervet.api.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping("/cita/{numeroCita}")
    public ResponseEntity<DetalleCita> obtenerReporteCita(@PathVariable String numeroCita) {
        return ResponseEntity.ok(reportesService.obtenerReporteCita(numeroCita));
    }

    @GetMapping("/citas-periodo")
    public ResponseEntity<List<DetalleCita>> obtenerCitasPorPeriodo(@RequestParam Instant desde, @RequestParam Instant hasta) {
        return ResponseEntity.ok(reportesService.obtenerCitasPorPeriodo(desde, hasta));
    }

    @GetMapping("/groomista-eficiente")
    public ResponseEntity<List<EmpleadoEficiente>> obtenerGroomistaMasEficiente() {
        return ResponseEntity.ok(reportesService.obtenerGroomistaMasEficiente());
    }

    @GetMapping("/veterinario-eficiente")
    public ResponseEntity<List<MedicoVeterinarioEficiente>> obtenerVeterinarioMasEficiente() {
        return ResponseEntity.ok(reportesService.obtenerVeterinarioMasEficiente());
    }

    @GetMapping("/reporte-ventas")
    public ResponseEntity<List<ReporteVentas>> obtenerReporteVentas(@RequestParam Instant desde, @RequestParam Instant hasta) {
        return ResponseEntity.ok(reportesService.obtenerReporteVentas(desde, hasta));
    }

    @GetMapping("/empleado-menos-trabajo")
    public ResponseEntity<EmpleadoEficiente> obtenerEmpleadoMenosTrabajo(@RequestParam Instant desde, @RequestParam Instant hasta) {
        return ResponseEntity.ok(reportesService.obtenerEmpleadoMenosTrabajo(desde, hasta));
    }

    @GetMapping("/servicio-mas-vendido")
    public ResponseEntity<ReporteVentas> obtenerServicioMasVendido(@RequestParam Instant desde, @RequestParam Instant hasta) {
        return ResponseEntity.ok(reportesService.obtenerServicioMasVendido(desde, hasta));
    }

    @GetMapping("/ocupacion-daycare")
    public ResponseEntity<List<OcupacionDayCare>> obtenerOcupacionDayCare(@RequestParam Instant desde, @RequestParam Instant hasta) {
        return ResponseEntity.ok(reportesService.obtenerOcupacionDayCare(desde, hasta));
    }

    @GetMapping("/disponibilidad-daycare")
    public ResponseEntity<List<DisponibilidadDayCare>> obtenerDisponibilidadDayCare(@RequestParam Instant fecha, @RequestParam String tallaPerro) {
        return ResponseEntity.ok(reportesService.obtenerDisponibilidadDayCare(fecha, tallaPerro));
    }

    @GetMapping("/empleado-mas-faltas")
    public ResponseEntity<List<EmpleadoFaltas>> obtenerEmpleadoMasFaltas(@RequestParam Integer mes, @RequestParam Integer anio) {
        return ResponseEntity.ok(reportesService.obtenerEmpleadoMasFaltas(mes, anio));
    }
}