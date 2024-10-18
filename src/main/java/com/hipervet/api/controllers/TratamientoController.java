package com.hipervet.api.controllers;

import com.hipervet.api.entities.DetalleDeTratamiento;
import com.hipervet.api.services.DetalleDeTratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {
    @Autowired
    private DetalleDeTratamientoService detalleDeTratamientoService;

    @GetMapping
    public List<DetalleDeTratamiento> getDetalleDeTratamientos() {
        return detalleDeTratamientoService.getDetalleDeTratamientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDeTratamiento> getDetalleDeTratamientoById(@PathVariable Integer id) {
        DetalleDeTratamiento detalleDeTratamientoById = detalleDeTratamientoService.getDetalleDeTratamientoById(id);
        if (detalleDeTratamientoById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalleDeTratamientoById);
    }

    @PostMapping
    public ResponseEntity<DetalleDeTratamiento> saveDetalleDeTratamiento(@RequestBody DetalleDeTratamiento detalleDeTratamiento) {
        return ResponseEntity.ok(detalleDeTratamientoService.saveDetalleDeTratamiento(detalleDeTratamiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleDeTratamiento> updateDetalleDeTratamiento(@PathVariable Integer id, @RequestBody DetalleDeTratamiento detalleDeTratamiento) {
        DetalleDeTratamiento updatedDetalleDeTratamiento = detalleDeTratamientoService.updateDetalleDeTratamiento(id, detalleDeTratamiento);
        if (updatedDetalleDeTratamiento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDetalleDeTratamiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleDeTratamiento(@PathVariable Integer id) {
        DetalleDeTratamiento detalleDeTratamiento = detalleDeTratamientoService.getDetalleDeTratamientoById(id);
        detalleDeTratamientoService.deleteDetalleDeTratamiento(detalleDeTratamiento);
        return ResponseEntity.noContent().build();
    }
}
