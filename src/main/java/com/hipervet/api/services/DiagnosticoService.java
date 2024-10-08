package com.hipervet.api.services;

import com.hipervet.api.entities.Cita;
import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;

import java.util.Date;
import java.util.List;

public interface DiagnosticoService {
    public void save(Diagnostico diagnostico);
    public void delete(Diagnostico diagnostico);
    public Diagnostico updateDiagnostico(Short id, Diagnostico diagnostico);
    public List<Diagnostico> findAll();
    public Diagnostico findById(Short id);
}
