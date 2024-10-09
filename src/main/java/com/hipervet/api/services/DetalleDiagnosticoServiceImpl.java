package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;
import com.hipervet.api.repositories.DetalleDiagnosticoRepository;
import com.hipervet.api.repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleDiagnosticoServiceImpl implements DetalleDiagnosticoService {

    @Autowired
    private DetalleDiagnosticoRepository detalleDiagnosticoRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public DetalleDiagnostico save(DetalleDiagnostico detalleDiagnostico) {
        // Verificar si existe el diagnostico
        if (diagnosticoRepository.existsById(detalleDiagnostico.getCodigoDiagnostico().getId())) {
            // Obtener el diagnostico y asignarlo al detalleDiagnostico
            Diagnostico diagnostico = diagnosticoRepository.findById(detalleDiagnostico.getCodigoDiagnostico().getId()).get();
            detalleDiagnostico.setCodigoDiagnostico(diagnostico);
            return detalleDiagnosticoRepository.save(detalleDiagnostico);
        }
        Diagnostico newDiagnostico = diagnosticoRepository.save(detalleDiagnostico.getCodigoDiagnostico());
        detalleDiagnostico.setCodigoDiagnostico(newDiagnostico);
        return detalleDiagnosticoRepository.save(detalleDiagnostico);
    }

    @Override
    public DetalleDiagnostico update(Integer id, DetalleDiagnostico detalleDiagnostico) {
        if (detalleDiagnosticoRepository.existsById(id)) {
            return detalleDiagnosticoRepository.save(detalleDiagnostico);
        }
        return null;
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
