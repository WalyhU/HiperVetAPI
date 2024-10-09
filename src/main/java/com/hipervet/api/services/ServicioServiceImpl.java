package com.hipervet.api.services;

import com.hipervet.api.entities.Servicio;
import com.hipervet.api.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Servicio saveServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void deleteServicio(Servicio servicio) {
        servicioRepository.delete(servicio);
    }

    @Override
    public Servicio updateServicio(Short id, Servicio servicio) {
        if (servicioRepository.existsById(id)) {
            servicio.setId(id);
            return servicioRepository.save(servicio);
        }
        return null;
    }

    @Override
    public Servicio getServicioById(Short id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }
}
