package com.hipervet.api.controllers;

import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.services.DetalleDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DetalleDiagnosticoService diagnosticoService;

    @GetMapping
    public List<DetalleDiagnostico> getDetalleDiagnosticos() {
        return diagnosticoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleDiagnostico> getDetalleDiagnosticoById(@PathVariable Integer id, @RequestBody DetalleDiagnostico detalleDiagnostico) {
        List<DetalleDiagnostico> diagnostico = diagnosticoService.findByDiagnostico(detalleDiagnostico.getCodigoDiagnostico());
        if (diagnostico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok((DetalleDiagnostico) diagnostico);
    }

    @PostMapping
    public ResponseEntity<DetalleDiagnostico> saveDetalleDiagnostico(@RequestBody DetalleDiagnostico detalleDiagnostico) {
        return ResponseEntity.ok(diagnosticoService.save(detalleDiagnostico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleDiagnostico> updateDetalleDiagnostico(@PathVariable Integer id, @RequestBody DetalleDiagnostico detalleDiagnostico) {
        DetalleDiagnostico updatedDetalleDiagnostico = diagnosticoService.update(id, detalleDiagnostico);
        if (updatedDetalleDiagnostico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDetalleDiagnostico);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDetalleDiagnostico(@RequestBody DetalleDiagnostico id) {
        diagnosticoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
