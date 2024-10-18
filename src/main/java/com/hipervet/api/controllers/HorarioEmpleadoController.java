package com.hipervet.api.controllers;

import com.hipervet.api.entities.HorarioEmpleado;
import com.hipervet.api.services.HorarioEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioEmpleadoController {
    @Autowired
    private HorarioEmpleadoService horarioEmpleadoService;

    @PostMapping
    public ResponseEntity<HorarioEmpleado> registrarHorario(@RequestBody HorarioEmpleado horario) {
        HorarioEmpleado nuevoHorario = horarioEmpleadoService.registrarHorario(horario);
        return ResponseEntity.ok(nuevoHorario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioEmpleado> actualizarHorario(@PathVariable Long id, @RequestBody HorarioEmpleado horario) {
        HorarioEmpleado horarioActualizado = horarioEmpleadoService.actualizarHorario(id, horario);
        return ResponseEntity.ok(horarioActualizado);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<List<HorarioEmpleado>> obtenerHorariosPorEmpleado(@PathVariable Long id) {
        List<HorarioEmpleado> horarios = horarioEmpleadoService.obtenerHorariosPorEmpleado(id);
        return ResponseEntity.ok(horarios);
    }

    @GetMapping
    public ResponseEntity<List<HorarioEmpleado>> obtenerHorarios() {
        List<HorarioEmpleado> horarios = horarioEmpleadoService.obtenerHorarios();
        return ResponseEntity.ok(horarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        horarioEmpleadoService.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }
}
