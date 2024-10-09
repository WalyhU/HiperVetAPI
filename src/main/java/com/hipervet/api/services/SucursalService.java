package com.hipervet.api.services;

import com.hipervet.api.entities.Sucursal;

import java.util.List;

public interface SucursalService {
    public Sucursal saveSucursal(Sucursal sucursal);
    public void deleteSucursal(Sucursal sucursal);
    public Sucursal updateSucursal(Short id, Sucursal sucursal);
    public Sucursal getSucursalById(Short id);
    public List<Sucursal> getAllSucursales();
}
