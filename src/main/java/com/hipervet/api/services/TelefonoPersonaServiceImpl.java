package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoPersona;
import com.hipervet.api.entities.TelefonoPersonaId;
import com.hipervet.api.repositories.TelefonoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoPersonaServiceImpl implements TelefonoPersonaService {

    @Autowired
    private TelefonoPersonaRepository telefonoPersonaRepository;

    @Override
    public void saveTelefonoPersona(TelefonoPersona telefonoPersona) {
        telefonoPersonaRepository.save(telefonoPersona);
    }

    @Override
    public void deleteTelefonoPersona(TelefonoPersona telefonoPersona) {
        telefonoPersonaRepository.delete(telefonoPersona);
    }

    @Override
    public void updateTelefonoPersona(TelefonoPersonaId id, TelefonoPersona telefonoPersona) {
        telefonoPersonaRepository.save(telefonoPersona);
    }

    @Override
    public TelefonoPersona getTelefonoPersonaById(TelefonoPersonaId id) {
        return telefonoPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public List<TelefonoPersona> getAllTelefonoPersonas() {
        return telefonoPersonaRepository.findAll();
    }
}
