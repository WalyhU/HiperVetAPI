package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;

import java.util.Date;
import java.util.List;

public interface DetalleDiagnosticoService {
    public DetalleDiagnostico save(DetalleDiagnostico detalleDiagnostico);
    public DetalleDiagnostico update(Integer id, DetalleDiagnostico detalleDiagnostico);
    public void delete(DetalleDiagnostico detalleDiagnostico);
    public List<DetalleDiagnostico> findAll();
    public List<DetalleDiagnostico> findByDetalleCita(DetalleCita detalleCita);
    public List<DetalleDiagnostico> findByDiagnostico(Diagnostico diagnostico);
}
