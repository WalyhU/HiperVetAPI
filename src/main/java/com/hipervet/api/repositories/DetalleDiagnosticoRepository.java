package com.hipervet.api.repositories;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleDiagnosticoRepository extends JpaRepository<DetalleDiagnostico, Integer> {
    public List<DetalleDiagnostico> findByDetalleCita(DetalleCita detalleCita);
    public List<DetalleDiagnostico> findByCodigoDiagnostico(Diagnostico diagnostico);
}
