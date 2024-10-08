package com.hipervet.api.controllers;

import com.hipervet.api.entities.Especie;
import com.hipervet.api.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {
    @Autowired
    private EspecieService especieService;

    @GetMapping
    public List<Especie> getAllEspecies() {
        return especieService.listarEspecies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especie> getEspecieById(@PathVariable Short id) {
        Especie especie = especieService.buscarEspeciePorId(id);
        return ResponseEntity.ok(especie);
    }

    @PostMapping
    public Especie createEspecie(@RequestBody Especie especie) {
        return especieService.salvarEspecie(especie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especie> updateEspecie(@PathVariable Short id, @RequestBody Especie especieDetails) {
        Especie updatedEspecie = especieService.atualizarEspecie(id, especieDetails);
        return ResponseEntity.ok(updatedEspecie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecie(@PathVariable Short id) {
        Optional<Especie> especie = Optional.ofNullable(especieService.buscarEspeciePorId(id));
        if (especie.isPresent()) {
            especieService.eliminarEspecie(especie.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
