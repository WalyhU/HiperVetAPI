package com.hipervet.api.controllers;

import com.hipervet.api.entities.Empleado;
import com.hipervet.api.entities.Puesto;
import com.hipervet.api.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> getEmpleados() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer id) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @GetMapping("/puesto")
    public ResponseEntity<List<Empleado>> getEmpleadosByPuesto(@RequestBody Puesto id) {
        List<Empleado> empleados = empleadoService.findByPuesto(id);
        if (empleados == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
        if (updatedEmpleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmpleado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmpleado(@RequestBody Empleado id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
