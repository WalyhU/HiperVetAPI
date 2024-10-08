package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;
import com.hipervet.api.repositories.DetalleDiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleDiagnosticoServiceImpl implements DetalleDiagnosticoService {

    @Autowired
    private DetalleDiagnosticoRepository detalleDiagnosticoRepository;

    @Override
    public void save(DetalleDiagnostico detalleDiagnostico) {
        detalleDiagnosticoRepository.save(detalleDiagnostico);
    }

    @Override
    public void delete(DetalleDiagnostico detalleDiagnostico) {
        detalleDiagnosticoRepository.delete(detalleDiagnostico);
    }

    @Override
    public List<DetalleDiagnostico> findAll() {
        return detalleDiagnosticoRepository.findAll();
    }

    @Override
    public List<DetalleDiagnostico> findByDetalleCita(DetalleCita detalleCita) {
        return detalleDiagnosticoRepository.findByDetalleCita(detalleCita);
    }

    @Override
    public List<DetalleDiagnostico> findByDiagnostico(Diagnostico diagnostico) {
        return detalleDiagnosticoRepository.findByCodigoDiagnostico(diagnostico);
    }
}
