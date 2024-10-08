package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;

import java.util.Date;
import java.util.List;

public interface DetalleDiagnosticoService {
    public void save(DetalleDiagnostico detalleDiagnostico);
    public void delete(DetalleDiagnostico detalleDiagnostico);
    public List<DetalleDiagnostico> findAll();
    public List<DetalleDiagnostico> findByDetalleCita(DetalleCita detalleCita);
    public List<DetalleDiagnostico> findByDiagnostico(Diagnostico diagnostico);
}
