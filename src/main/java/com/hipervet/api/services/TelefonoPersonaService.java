package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoPersona;

import java.util.List;

public interface TelefonoPersonaService {
    public void saveTelefonoPersona(TelefonoPersona telefonoPersona);
    public void deleteTelefonoPersona(TelefonoPersona telefonoPersona);
    public void updateTelefonoPersona(Integer id, TelefonoPersona telefonoPersona);
    public TelefonoPersona getTelefonoPersonaById(Integer id);
    public List<TelefonoPersona> getAllTelefonoPersonas();
}
