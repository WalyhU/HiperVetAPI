package com.hipervet.api.controllers;

import com.hipervet.api.entities.*;
import com.hipervet.api.services.DetalleCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private DetalleCitaService detalleCitaService;

    @GetMapping
    public List<DetalleCita> getAllCitas() {
        return detalleCitaService.getDetalleCitas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCita> getCitaById(@PathVariable Cita id) {
        List<DetalleCita> cita = detalleCitaService.getDetalleCitasByCita(id);
        return ResponseEntity.ok((DetalleCita) cita);
    }

    @GetMapping("/servicio/{id}")
    public ResponseEntity<List<DetalleCita>> getCitaByServicio(@PathVariable Servicio id) {
        List<DetalleCita> citas = detalleCitaService.getDetalleCitasByServicio(id);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<List<DetalleCita>> getCitaByEmpleado(@PathVariable Empleado id) {
        List<DetalleCita> citas = detalleCitaService.getDetalleCitasByEmpleado(id);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/correlativo")
    public ResponseEntity<String> getCorrelativo() {
        String correlativo = detalleCitaService.getCorrelativo();
        return ResponseEntity.ok(correlativo);
    }

    @GetMapping("/fecha/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<DetalleCita>> getCitaByFechaBetween(@PathVariable Instant fechaInicio, @PathVariable Instant fechaFin) {
        List<DetalleCita> citas = detalleCitaService.getDetalleCitasByFechaBetween(fechaInicio, fechaFin);
        return ResponseEntity.ok(citas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        Optional<DetalleCita> cita = Optional.ofNullable(detalleCitaService.getDetalleCitaById(id));
        if (cita.isPresent()) {
            detalleCitaService.deleteDetalleCita(cita.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public DetalleCita createCita(@RequestBody DetalleCita cita) {
        return detalleCitaService.saveDetalleCita(cita);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DetalleCita> updateCita(@PathVariable Integer id, @RequestBody DetalleCita citaDetails) {
        DetalleCita updatedCita = detalleCitaService.updateDetalleCita(id, citaDetails);
        return ResponseEntity.ok(updatedCita);
    }
}
