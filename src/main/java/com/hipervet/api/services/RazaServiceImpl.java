package com.hipervet.api.services;

import com.hipervet.api.entities.Raza;
import com.hipervet.api.repositories.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaServiceImpl implements RazaService {

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public Raza saveRaza(Raza raza) {
        return razaRepository.save(raza);
    }

    @Override
    public List<Raza> getRazas() {
        return razaRepository.findAll();
    }

    @Override
    public Raza getRazaById(Short id) {
        return razaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRazaById(Short id) {
        razaRepository.deleteById(id);
    }

    @Override
    public Raza updateRazaById(Short id, Raza raza) {
        if (razaRepository.existsById(id)) {
            raza.setId(id);
            return razaRepository.save(raza);
        }
        return null;
    }
}
