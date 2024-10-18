package com.hipervet.api.controllers;

import com.hipervet.api.entities.*;
import com.hipervet.api.services.PersonaService;
import com.hipervet.api.services.SucursalService;
import com.hipervet.api.services.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telefono")
public class TelefonoController {
    @Autowired
    private TelefonoService telefonoService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Telefono>> getAllTelefonos() {
        return ResponseEntity.ok(telefonoService.getAllTelefonos());
    }

    @GetMapping("/persona")
    public ResponseEntity<List<TelefonoPersona>> getAllTelefonosPersona() {
        return ResponseEntity.ok(telefonoService.getAllTelefonoPersona());
    }

    @GetMapping("/sucursal")
    public ResponseEntity<List<TelefonoSucursal>> getAllTelefonosSucursal() {
        return ResponseEntity.ok(telefonoService.getAllTelefonoSucursal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefono> getTelefonoById(@PathVariable Integer id) {
        return ResponseEntity.ok(telefonoService.getTelefonoById(id));
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<List<TelefonoPersona>> getTelefonoPersonaByCodigoPersona(@PathVariable Integer id) {
        Persona persona = personaService.getPersonaById(id);
        return ResponseEntity.ok(telefonoService.getTelefonoPersonaByCodigoPersona(persona));
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<TelefonoSucursal>> getTelefonoSucursalByCodigoSucursal(@PathVariable Short id) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        return ResponseEntity.ok(telefonoService.getTelefonoSucursalByCodigoSucursal(sucursal));
    }

    @PostMapping("/persona")
    public ResponseEntity<TelefonoPersona> asignarTelefonoPersona(@RequestBody TelefonoPersona telefonoPersona) {
        Persona persona = personaService.getPersonaById(telefonoPersona.getCodigoPersona().getId());
        return ResponseEntity.ok(telefonoService.asignarTelefonoPersona(persona, telefonoPersona.getCorrelativoTelefono()));
    }

    @PostMapping("/sucursal")
    public ResponseEntity<TelefonoSucursal> asignarTelefonoSucursal(@RequestBody TelefonoSucursal telefonoSucursal) {
        Sucursal sucursal = sucursalService.getSucursalById(telefonoSucursal.getCodigoSucursal().getId());
        return ResponseEntity.ok(telefonoService.asignarTelefonoSucursal(sucursal, telefonoSucursal.getCorrelativoTelefono()));
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<TelefonoPersona> updateTelefonoPersona(@PathVariable Integer id, @RequestBody TelefonoPersona telefonoPersona) {
        return ResponseEntity.ok(telefonoService.updateTelefonoPersona(id, telefonoPersona));
    }

    @PutMapping("/sucursal/{id}")
    public ResponseEntity<TelefonoSucursal> updateTelefonoSucursal(@PathVariable Integer id, @RequestBody TelefonoSucursal telefonoSucursal) {
        return ResponseEntity.ok(telefonoService.updateTelefonoSucursal(id, telefonoSucursal));
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Void> deleteTelefonoPersona(@PathVariable Integer id) {
        telefonoService.deleteTelefonoPersona(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/sucursal/{id}")
    public ResponseEntity<Void> deleteTelefonoSucursal(@PathVariable Integer id) {
        telefonoService.deleteTelefonoSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
