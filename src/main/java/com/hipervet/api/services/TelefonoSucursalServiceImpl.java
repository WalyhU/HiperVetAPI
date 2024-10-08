package com.hipervet.api.services;

import com.hipervet.api.entities.TelefonoSucursal;
import com.hipervet.api.entities.TelefonoSucursalId;
import com.hipervet.api.repositories.TelefonoSucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoSucursalServiceImpl implements TelefonoSucursalService {

    @Autowired
    private TelefonoSucursalRepository telefonoSucursalRepository;

    @Override
    public void saveTelefonoSucursal(TelefonoSucursal telefonoSucursal) {
        telefonoSucursalRepository.save(telefonoSucursal);
    }

    @Override
    public void deleteTelefonoSucursal(TelefonoSucursal telefonoSucursal) {
        telefonoSucursalRepository.delete(telefonoSucursal);
    }

    @Override
    public void updateTelefonoSucursal(TelefonoSucursal telefonoSucursal) {
        telefonoSucursalRepository.save(telefonoSucursal);
    }

    @Override
    public TelefonoSucursal getTelefonoSucursalById(TelefonoSucursalId id) {
        return telefonoSucursalRepository.findById(id).orElse(null);
    }

    @Override
    public TelefonoSucursal getTelefonoSucursalByNumero(String numero) {
        return null;
    }

    @Override
    public List<TelefonoSucursal> getAllTelefonosSucursal() {
        return List.of();
    }
}
