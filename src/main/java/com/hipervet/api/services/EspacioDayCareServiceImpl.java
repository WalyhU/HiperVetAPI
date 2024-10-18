package com.hipervet.api.services;

import com.hipervet.api.entities.EspacioDayCare;
import com.hipervet.api.repositories.EspacioDayCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioDayCareServiceImpl implements EspacioDayCareService {

    @Autowired
    private EspacioDayCareRepository espacioDayCareRepository;

    @Override
    public EspacioDayCare registrarEspacio(EspacioDayCare espacioDayCare) {
        return espacioDayCareRepository.save(espacioDayCare);
    }

    @Override
    public List<EspacioDayCare> obtenerEspaciosPorTallaPerro(String tallaPerro) {
        return espacioDayCareRepository.findByTallaPerro(tallaPerro);
    }

    @Override
    public EspacioDayCare actualizarEspacio(Long id, Integer espaciosOcupados) {
        EspacioDayCare espacio = espacioDayCareRepository.findById(id).orElseThrow();
        espacio.setEspaciosOcupados(espaciosOcupados);
        return espacioDayCareRepository.save(espacio);
    }

    @Override
    public List<EspacioDayCare> obtenerEspacios() {
        return espacioDayCareRepository.findAll();
    }

}
