package com.hipervet.api.services;

import com.hipervet.api.entities.Sucursal;
import com.hipervet.api.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Sucursal saveSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void deleteSucursal(Sucursal sucursal) {
        sucursalRepository.delete(sucursal);
    }

    @Override
    public Sucursal updateSucursal(Short id, Sucursal sucursal) {
        if (sucursalRepository.existsById(id)) {
            sucursal.setId(id);
            return sucursalRepository.save(sucursal);
        }
        return null;
    }

    @Override
    public Sucursal getSucursalById(Short id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sucursal> getAllSucursales() {
        return sucursalRepository.findAll();
    }
}
