package com.hipervet.api.controllers;

import com.hipervet.api.entities.Sucursal;
import com.hipervet.api.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        return ResponseEntity.ok(sucursalService.getAllSucursales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Short id) {
        Sucursal sucursal = sucursalService.getSucursalById(id);
        return ResponseEntity.ok(sucursal);
    }

    @PostMapping
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        Sucursal newSucursal = sucursalService.saveSucursal(sucursal);
        return ResponseEntity.ok(newSucursal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Short id, @RequestBody Sucursal sucursal) {
        Sucursal updatedSucursal = sucursalService.updateSucursal(id, sucursal);
        return ResponseEntity.ok(updatedSucursal);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSucursal(@RequestBody Sucursal id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
