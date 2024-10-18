package com.hipervet.api.services;

import com.hipervet.api.entities.*;

import java.util.List;

public interface TelefonoService {
    TelefonoPersona asignarTelefonoPersona(Persona codigoPersona, Telefono numeroTelefono);
    TelefonoSucursal asignarTelefonoSucursal(Sucursal codigoSucursal, Telefono numeroTelefono);
    public void deleteTelefonoPersona(Integer id);
    public void deleteTelefonoSucursal(Integer id);
    public TelefonoPersona updateTelefonoPersona(Integer id, TelefonoPersona telefonoPersona);
    public TelefonoSucursal updateTelefonoSucursal(Integer id, TelefonoSucursal telefonoSucursal);
    public List<Telefono> getAllTelefonos();
    public Telefono getTelefonoById(Integer id);
    public List<TelefonoPersona> getTelefonoPersonaByCodigoPersona(Persona id);
    public List<TelefonoSucursal> getTelefonoSucursalByCodigoSucursal(Sucursal id);
    public List<TelefonoPersona> getAllTelefonoPersona();
    public List<TelefonoSucursal> getAllTelefonoSucursal();
}
