package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoPersona;
import com.hipervet.api.entities.TelefonoPersonaId;

import java.util.List;

public interface TelefonoPersonaService {
    public void saveTelefonoPersona(TelefonoPersona telefonoPersona);
    public void deleteTelefonoPersona(TelefonoPersona telefonoPersona);
    public void updateTelefonoPersona(TelefonoPersonaId id, TelefonoPersona telefonoPersona);
    public TelefonoPersona getTelefonoPersonaById(TelefonoPersonaId id);
    public List<TelefonoPersona> getAllTelefonoPersonas();
}
