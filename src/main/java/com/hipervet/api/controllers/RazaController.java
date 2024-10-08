package com.hipervet.api.controllers;

import com.hipervet.api.entities.Raza;
import com.hipervet.api.services.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/razas")
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping
    public List<Raza> getAllRazas() {
        return razaService.getRazas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Raza> getRazaById(@PathVariable Short id) {
        Raza raza = razaService.getRazaById(id);
        return ResponseEntity.ok(raza);
    }

    @PostMapping
    public ResponseEntity<Raza> createRaza(@RequestBody Raza raza) {
        Raza newRaza = razaService.saveRaza(raza);
        return ResponseEntity.ok(newRaza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Raza> updateRaza(@PathVariable Short id, @RequestBody Raza razaDetails) {
        Raza updatedRaza = razaService.updateRazaById(id, razaDetails);
        return ResponseEntity.ok(updatedRaza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable Short id) {
        Optional<Raza> raza = Optional.ofNullable(razaService.getRazaById(id));
        if (raza.isPresent()) {
            razaService.deleteRazaById(raza.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
