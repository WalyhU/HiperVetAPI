package com.hipervet.api.services;

import com.hipervet.api.entities.*;
import com.hipervet.api.repositories.DetalleCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DetalleCitaServiceImpl implements DetalleCitaService {

    @Autowired
    private DetalleCitaRepository detalleCitaRepository;

    @Autowired
    private CitaService citaService;

    @Override
    public DetalleCita saveDetalleCita(DetalleCita detalleCita) {
        Cita cita = detalleCita.getCita();
        if (cita != null) {
            citaService.saveCita(cita);
        }
        return detalleCitaRepository.save(detalleCita);
    }

    @Override
    public void deleteDetalleCita(DetalleCita detalleCita) {
        detalleCitaRepository.delete(detalleCita);
    }

    @Override
    public DetalleCita updateDetalleCita(DetalleCitaId detalleCitaId, DetalleCita detalleCita) {
        if (detalleCitaRepository.existsById(detalleCitaId)) {
            detalleCita.setId(detalleCitaId);
            Cita cita = detalleCita.getCita();
            if (cita != null) {
                citaService.saveCita(cita);
            }
            return detalleCitaRepository.save(detalleCita);
        }
        return null;
    }

    @Override
    public List<DetalleCita> getDetalleCitas() {
        return detalleCitaRepository.findAll();
    }

    @Override
    public DetalleCita getDetalleCitaById(DetalleCitaId id) {
        return detalleCitaRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByCita(Cita cita) {
        return detalleCitaRepository.findDetalleCitasByCita(cita);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByServicio(Servicio servicio) {
        return detalleCitaRepository.findDetalleCitasByCodigoServicio(servicio);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByEmpleado(Empleado empleado) {
        return detalleCitaRepository.findDetalleCitasByCodigoEmpleado(empleado);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByFechaBetween(Instant fechaInicio, Instant fechaFin) {
        return detalleCitaRepository.findDetalleCitasByInicioBetween(fechaInicio, fechaFin);
    }
}
