package com.hipervet.api.services;

import com.hipervet.api.entities.Diagnostico;
import com.hipervet.api.repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public void save(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public void delete(Diagnostico diagnostico) {
        diagnosticoRepository.delete(diagnostico);
    }

    @Override
    public Diagnostico updateDiagnostico(Short id, Diagnostico diagnostico) {
        if (diagnosticoRepository.existsById(id)) {
            diagnostico.setId(id);
            diagnosticoRepository.save(diagnostico);
            return diagnostico;
        }
        return null;
    }

    @Override
    public List<Diagnostico> findAll() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public Diagnostico findById(Short id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }
}
