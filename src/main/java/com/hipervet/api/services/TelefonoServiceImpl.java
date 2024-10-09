package com.hipervet.api.services;

import com.hipervet.api.entities.*;
import com.hipervet.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Autowired
    private TelefonoPersonaRepository telefonoPersonaRepository;

    @Autowired
    private TelefonoSucursalRepository telefonoSucursalRepository;

    @Override
    public TelefonoPersona asignarTelefonoPersona(Persona codigoPersona, Telefono numeroTelefono) {
        // 1. Verificar si la persona existe
        Persona persona = personaRepository.findById(codigoPersona.getId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el código: " + codigoPersona));

        // Verificar si el teléfono ya existe
        Telefono telefono = telefonoRepository.findById(numeroTelefono.getId())
                .orElseGet(() -> telefonoRepository.save(new Telefono(0, numeroTelefono.getNumeroTelefono())));

        TelefonoPersona telefonoPersona = new TelefonoPersona();
        telefonoPersona.setCodigoPersona(persona);
        telefonoPersona.setCorrelativoTelefono(telefono);
        return telefonoPersonaRepository.save(telefonoPersona);
    }

    @Override
    public TelefonoSucursal asignarTelefonoSucursal(Sucursal codigoSucursal, Telefono numeroTelefono) {
        // 1. Verificar si la sucursal existe
        Sucursal sucursal = sucursalRepository.findById(codigoSucursal.getId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con el código: " + codigoSucursal.getId()));

        // Verificar si el teléfono ya existe
        Telefono telefono = telefonoRepository.findById(numeroTelefono.getId())
                .orElseGet(() -> telefonoRepository.save(new Telefono(0, numeroTelefono.getNumeroTelefono())));

        TelefonoSucursal telefonoSucursal = new TelefonoSucursal();
        telefonoSucursal.setCodigoSucursal(sucursal);
        telefonoSucursal.setCorrelativoTelefono(telefono);
        return telefonoSucursalRepository.save(telefonoSucursal);
    }

    @Override
    public void deleteTelefonoPersona(Telefono id) {
        telefonoPersonaRepository.deleteTelefonoPersonaByCorrelativoTelefono(id);
    }

    @Override
    public void deleteTelefonoSucursal(Telefono id) {
        telefonoSucursalRepository.deleteTelefonoSucursalByCorrelativoTelefono(id);
    }

    @Override
    public TelefonoPersona updateTelefonoPersona(Integer id, TelefonoPersona telefonoPersona) {
        Telefono telefono = telefonoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        telefono.setNumeroTelefono(telefonoPersona.getCorrelativoTelefono().getNumeroTelefono());
        telefono = telefonoRepository.save(telefono);
        telefonoPersona.setCorrelativoTelefono(telefono);
        return telefonoPersonaRepository.save(telefonoPersona);
    }

    @Override
    public TelefonoSucursal updateTelefonoSucursal(Integer id, TelefonoSucursal telefonoSucursal) {
        Telefono telefono = telefonoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        telefono.setNumeroTelefono(telefonoSucursal.getCorrelativoTelefono().getNumeroTelefono());
        telefono = telefonoRepository.save(telefono);
        telefonoSucursal.setCorrelativoTelefono(telefono);
        return telefonoSucursalRepository.save(telefonoSucursal);
    }

    @Override
    public Telefono getTelefonoById(Integer id) {
        return telefonoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
    }

    @Override
    public List<TelefonoPersona> getTelefonoPersonaByCodigoPersona(Persona id) {
        return telefonoPersonaRepository.findAllByCodigoPersona(id);
    }

    @Override
    public List<TelefonoSucursal> getTelefonoSucursalByCodigoSucursal(Sucursal id) {
        return telefonoSucursalRepository.findAllByCodigoSucursal(id);
    }

    @Override
    public List<Telefono> getAllTelefonos() {
        return telefonoRepository.findAll();
    }
}
