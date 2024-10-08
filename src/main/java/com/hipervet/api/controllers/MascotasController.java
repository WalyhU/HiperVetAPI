package com.hipervet.api.controllers;

import com.hipervet.api.entities.FichaMascota;
import com.hipervet.api.services.FichaMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class MascotasController {

    @Autowired
    private FichaMascotaService fichaMascotaService;

    // Obtener todas las fichas de mascota
    @GetMapping
    public List<FichaMascota> getAllFichasMascota() {
        return fichaMascotaService.getAllFichasMascota();
    }

    // Obtener ficha de mascota por ID
    @GetMapping("/{id}")
    public ResponseEntity<FichaMascota> getFichaMascotaById(@PathVariable Integer id) {
        Optional<FichaMascota> fichaMascota = fichaMascotaService.getFichaMascotaById(id);
        return fichaMascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva ficha de mascota
    @PostMapping
    public FichaMascota createFichaMascota(@RequestBody FichaMascota fichaMascota) {
        return fichaMascotaService.saveFichaMascota(fichaMascota);
    }

    // Actualizar una ficha de mascota existente
    @PutMapping("/{id}")
    public ResponseEntity<FichaMascota> updateFichaMascota(@PathVariable Integer id, @RequestBody FichaMascota fichaMascotaDetails) {
        FichaMascota updatedFichaMascota = fichaMascotaService.updateFichaMascota(id, fichaMascotaDetails);
        return ResponseEntity.ok(updatedFichaMascota);
    }

    // Eliminar una ficha de mascota por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFichaMascota(@PathVariable Integer id) {
        fichaMascotaService.deleteFichaMascota(id);
        return ResponseEntity.noContent().build();
    }
}
