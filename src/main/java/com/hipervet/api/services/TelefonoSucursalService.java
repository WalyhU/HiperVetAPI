package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoSucursal;

import java.util.List;

public interface TelefonoSucursalService {
    public void saveTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public void deleteTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public void updateTelefonoSucursal(TelefonoSucursal telefonoSucursal);
    public TelefonoSucursal getTelefonoSucursalById(Integer id);
    public TelefonoSucursal getTelefonoSucursalByNumero(String numero);
    public List<TelefonoSucursal> getAllTelefonosSucursal();
}
