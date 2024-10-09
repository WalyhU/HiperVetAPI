package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleDeTratamiento;
import com.hipervet.api.entities.Tratamiento;
import com.hipervet.api.repositories.DetalleDeTratamientoRepository;
import com.hipervet.api.repositories.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleDeTratamientoServiceImpl implements DetalleDeTratamientoService {

    @Autowired
    private DetalleDeTratamientoRepository detalleDeTratamientoRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public DetalleDeTratamiento saveDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento) {
        Tratamiento tratamiento = detalleDeTratamiento.getCodigoTratamiento();
        Tratamiento newTratamiento = tratamientoRepository.save(tratamiento);
        detalleDeTratamiento.setCodigoTratamiento(newTratamiento);
        return detalleDeTratamientoRepository.save(detalleDeTratamiento);
    }

    @Override
    public DetalleDeTratamiento updateDetalleDeTratamiento(Integer id, DetalleDeTratamiento detalleDeTratamiento) {
        if (detalleDeTratamientoRepository.existsById(id)) {
            return detalleDeTratamientoRepository.save(detalleDeTratamiento);
        }
        return null;
    }

    @Override
    public void deleteDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento) {
        if (detalleDeTratamientoRepository.existsById(detalleDeTratamiento.getCodigoDetalleTratamiento())) {
            detalleDeTratamientoRepository.delete(detalleDeTratamiento);
        }
    }

    @Override
    public DetalleDeTratamiento getDetalleDeTratamientoById(Tratamiento id) {
        return (DetalleDeTratamiento) detalleDeTratamientoRepository.findDetalleDeTratamientosByCodigoTratamiento(id);
    }

    @Override
    public List<DetalleDeTratamiento> getDetalleDeTratamientos() {
        return detalleDeTratamientoRepository.findAll();
    }

    @Override
    public List<DetalleDeTratamiento> getDetalleDeTratamientosByTratamiento(Tratamiento tratamiento) {
        return detalleDeTratamientoRepository.findDetalleDeTratamientosByCodigoTratamiento(tratamiento);
    }
}
