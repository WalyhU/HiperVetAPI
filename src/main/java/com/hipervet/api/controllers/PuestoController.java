package com.hipervet.api.controllers;

import com.hipervet.api.entities.Puesto;
import com.hipervet.api.services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {
    @Autowired
    private PuestoService puestoService;

    @GetMapping
    public ResponseEntity<List<Puesto>> getAllPuestos() {
        return ResponseEntity.ok(puestoService.getPuestos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> getPuestoById(@PathVariable Short id) {
        Puesto puesto = puestoService.getPuestoById(id);
        if (puesto != null) {
            return ResponseEntity.ok(puesto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Puesto> createPuesto(@RequestBody Puesto puesto) {
        Puesto newPuesto = puestoService.savePuesto(puesto);
        return ResponseEntity.ok(newPuesto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puesto> updatePuesto(@PathVariable Short id, @RequestBody Puesto puesto) {
        Puesto updatedPuesto = puestoService.updatePuestoById(id, puesto);
        if (updatedPuesto != null) {
            return ResponseEntity.ok(updatedPuesto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuesto(@PathVariable Short id) {
        puestoService.deletePuestoById(id);
        return ResponseEntity.noContent().build();
    }

}
