package com.hipervet.api.controllers;

import com.hipervet.api.entities.EspacioDayCare;
import com.hipervet.api.services.EspacioDayCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daycare")
public class EspacioDayCareController {
    @Autowired
    private EspacioDayCareService espacioDayCareService;

    @PostMapping
    public ResponseEntity<EspacioDayCare> crearEspacio(@RequestBody EspacioDayCare espacio) {
        EspacioDayCare espacioCreado = espacioDayCareService.registrarEspacio(espacio);
        return ResponseEntity.ok(espacioCreado);
    }

    @PutMapping("/actualizar/{id}/{espaciosOcupados}")
    public ResponseEntity<EspacioDayCare> actualizarEspacio(@PathVariable Long id, @PathVariable Integer espaciosOcupados) {
        EspacioDayCare espacio = espacioDayCareService.actualizarEspacio(id, espaciosOcupados);
        return ResponseEntity.ok(espacio);
    }

    @GetMapping("/talla/{tallaPerro}")
    public ResponseEntity<List<EspacioDayCare>> obtenerEspacioPorTalla(@PathVariable String tallaPerro) {
        List<EspacioDayCare> espacio = espacioDayCareService.obtenerEspaciosPorTallaPerro(tallaPerro);
        return ResponseEntity.ok(espacio);
    }

    @GetMapping
    public ResponseEntity<List<EspacioDayCare>> obtenerEspacios() {
        List<EspacioDayCare> espacios = espacioDayCareService.obtenerEspacios();
        return ResponseEntity.ok(espacios);
    }
}
