package com.hipervet.api.services;

import com.hipervet.api.entities.Telefono;

import java.util.List;

public interface TelefonoService {
    public void saveTelefono(Telefono telefono);
    public void deleteTelefono(Telefono telefono);
    public void updateTelefono(Integer id, Telefono telefono);
    public Telefono getTelefonoById(Integer id);
    public List<Telefono> getAllTelefonos();
}
