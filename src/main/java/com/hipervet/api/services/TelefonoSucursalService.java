package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoSucursal;
import com.hipervet.api.entities.TelefonoSucursalId;

import java.util.List;

public interface TelefonoSucursalService {
    public void saveTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public void deleteTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public void updateTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public TelefonoSucursal getTelefonoSucursalById(TelefonoSucursalId id);
    public TelefonoSucursal getTelefonoSucursalByNumero(String numero);
    public List<TelefonoSucursal> getAllTelefonosSucursal();
}
