package com.hipervet.api.services;

import com.hipervet.api.entities.Puesto;
import com.hipervet.api.repositories.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuestoServiceImpl implements PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;

    @Override
    public void savePuesto(Puesto puesto) {
        puestoRepository.save(puesto);
    }

    @Override
    public List<Puesto> getPuestos() {
        return puestoRepository.findAll();
    }

    @Override
    public Puesto getPuestoById(Short id) {
        return puestoRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePuestoById(Short id) {
        puestoRepository.deleteById(id);
    }

    @Override
    public void updatePuestoById(Short id, Puesto puesto) {
        if (puestoRepository.existsById(id)) {
            puesto.setId(id);
            puestoRepository.save(puesto);
        }
    }
}
