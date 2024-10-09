package com.hipervet.api.controllers;

import com.hipervet.api.entities.Servicio;
import com.hipervet.api.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicios() {
        return ResponseEntity.ok(servicioService.getAllServicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Short id) {
        Servicio servicio = servicioService.getServicioById(id);
        return ResponseEntity.ok(servicio);
    }

    @PostMapping
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio) {
        Servicio newServicio = servicioService.saveServicio(servicio);
        return ResponseEntity.ok(newServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Short id, @RequestBody Servicio servicio) {
        Servicio updatedServicio = servicioService.updateServicio(id, servicio);
        return ResponseEntity.ok(updatedServicio);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteServicio(@RequestBody Servicio id) {
        servicioService.deleteServicio(id);
        return ResponseEntity.noContent().build();
    }
}
