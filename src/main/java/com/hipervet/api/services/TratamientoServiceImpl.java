package com.hipervet.api.services;

import com.hipervet.api.entities.Tratamiento;
import com.hipervet.api.repositories.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public void saveTratamiento(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void deleteTratamiento(Tratamiento tratamiento) {
        tratamientoRepository.delete(tratamiento);
    }

    @Override
    public void updateTratamiento(Short id, Tratamiento tratamiento) {
        if (tratamientoRepository.existsById(id)) {
            tratamientoRepository.save(tratamiento);
        }
    }

    @Override
    public Tratamiento getTratamientoById(Short id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public Tratamiento getTratamientoByDescripcion(String descripcion) {
        return tratamientoRepository.getTratamientoByDescripcion(descripcion);
    }

    @Override
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAll();
    }
}
