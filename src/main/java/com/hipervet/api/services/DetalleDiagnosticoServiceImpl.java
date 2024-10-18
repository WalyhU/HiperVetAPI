package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleCita;
import com.hipervet.api.entities.DetalleDiagnostico;
import com.hipervet.api.entities.Diagnostico;
import com.hipervet.api.repositories.DetalleDiagnosticoRepository;
import com.hipervet.api.repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DetalleDiagnosticoServiceImpl implements DetalleDiagnosticoService {

    @Autowired
    private DetalleDiagnosticoRepository detalleDiagnosticoRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private DetalleCitaService detalleCitaService;

    @Override
    public DetalleDiagnostico save(DetalleDiagnostico detalleDiagnostico) {
        // Verificar si existe el diagnostico
        Diagnostico newDiagnostico = diagnosticoRepository.save(detalleDiagnostico.getCodigoDiagnostico());
        DetalleCita detalleCita = detalleCitaService.getDetalleCitaById(detalleDiagnostico.getDetalleCita().getId());
        detalleDiagnostico.setCodigoDiagnostico(newDiagnostico);
        detalleDiagnostico.setDetalleCita(detalleCita);
        detalleDiagnostico.setCodigoDetalleDiagnostico(getCorrelativo());
        return detalleDiagnosticoRepository.save(detalleDiagnostico);
    }

    @Override
    public DetalleDiagnostico update(Integer id, DetalleDiagnostico detalleDiagnostico) {
        if (detalleDiagnosticoRepository.existsById(id)) {
            diagnosticoRepository.save(detalleDiagnostico.getCodigoDiagnostico());
            detalleDiagnostico.setCodigoDetalleDiagnostico(id);
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

    public Integer getCorrelativo() {
        List<DetalleDiagnostico> detalleDiagnosticos = detalleDiagnosticoRepository.findAll();
        if (detalleDiagnosticos.isEmpty()) {
            return 1;
        }
        return detalleDiagnosticos.getLast().getCodigoDetalleDiagnostico() + 1;
    }
}
