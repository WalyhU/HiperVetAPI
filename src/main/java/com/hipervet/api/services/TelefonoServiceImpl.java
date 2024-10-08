package com.hipervet.api.services;

import com.hipervet.api.entities.Telefono;
import com.hipervet.api.repositories.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoServiceImpl implements TelefonoService{

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    public void saveTelefono(Telefono telefono) {
        telefonoRepository.save(telefono);
    }

    @Override
    public void deleteTelefono(Telefono telefono) {
        telefonoRepository.delete(telefono);
    }

    @Override
    public void updateTelefono(Integer id, Telefono telefono) {
        telefonoRepository.save(telefono);
    }

    @Override
    public Telefono getTelefonoById(Integer id) {
        return telefonoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Telefono> getAllTelefonos() {
        return telefonoRepository.findAll();
    }
}
