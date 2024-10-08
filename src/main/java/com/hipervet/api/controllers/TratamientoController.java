package com.hipervet.api.controllers;

import com.hipervet.api.entities.DetalleDeTratamiento;
import com.hipervet.api.services.DetalleDeTratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DetalleDeTratamiento getDetalleDeTratamientoById(@PathVariable Integer id, @RequestBody DetalleDeTratamiento detalleDeTratamiento) {
        return detalleDeTratamientoService.getDetalleDeTratamientoById(detalleDeTratamiento.getCodigoTratamiento());
    }
}
