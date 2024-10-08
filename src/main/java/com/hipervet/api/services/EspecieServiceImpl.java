package com.hipervet.api.services;

import com.hipervet.api.entities.Especie;
import com.hipervet.api.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    @Override
    public List<Especie> listarEspecies() {
        return especieRepository.findAll();
    }

    @Override
    public Especie buscarEspeciePorId(Short id) {
        return especieRepository.findById(id).orElse(null);
    }

    @Override
    public Especie salvarEspecie(Especie especie) {
        return especieRepository.save(especie);
    }

    @Override
    public void eliminarEspecie(Short id) {
        especieRepository.deleteById(id);
    }

    @Override
    public Especie atualizarEspecie(Short id, Especie especie) {
        if (especieRepository.existsById(id)) {
            especie.setId(id);
            return especieRepository.save(especie);
        }
        return null;
    }
}
