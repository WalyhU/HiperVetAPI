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
        Telefono telefono = telefonoRepository.save(new Telefono(null, numeroTelefono.getNumeroTelefono()));

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
        Telefono telefono = telefonoRepository.save(new Telefono(null, numeroTelefono.getNumeroTelefono()));

        TelefonoSucursal telefonoSucursal = new TelefonoSucursal();
        telefonoSucursal.setCodigoSucursal(sucursal);
        telefonoSucursal.setCorrelativoTelefono(telefono);
        return telefonoSucursalRepository.save(telefonoSucursal);
    }

    @Override
    public void deleteTelefonoPersona(Integer id) {
        TelefonoPersona telefonoPersona = telefonoPersonaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        Integer idTelefono = telefonoPersona.getCorrelativoTelefono().getId();
        telefonoPersonaRepository.deleteById(id);
        telefonoRepository.deleteById(idTelefono);
    }

    @Override
    public void deleteTelefonoSucursal(Integer id) {
        TelefonoSucursal telefonoSucursal = telefonoSucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        Integer idTelefono = telefonoSucursal.getCorrelativoTelefono().getId();
        telefonoSucursalRepository.deleteById(id);
        telefonoRepository.deleteById(idTelefono);
    }

    @Override
    public TelefonoPersona updateTelefonoPersona(Integer id, TelefonoPersona telefonoPersona) {
        TelefonoPersona telefonoPersona1 = telefonoPersonaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        Telefono telefono = telefonoRepository.findById(telefonoPersona1.getCorrelativoTelefono().getId())
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        telefono.setNumeroTelefono(telefonoPersona.getCorrelativoTelefono().getNumeroTelefono());
        telefono = telefonoRepository.save(telefono);
        telefonoPersona1.setCorrelativoTelefono(telefono);
        Persona persona = personaRepository.findById(telefonoPersona.getCodigoPersona().getId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con el código: " + telefonoPersona.getCodigoPersona().getId()));
        telefonoPersona1.setCodigoPersona(persona);
        return telefonoPersonaRepository.save(telefonoPersona1);
    }

    @Override
    public TelefonoSucursal updateTelefonoSucursal(Integer id, TelefonoSucursal telefonoSucursal) {
        TelefonoSucursal telefonoSucursal1 = telefonoSucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        Telefono telefono = telefonoRepository.findById(telefonoSucursal1.getCorrelativoTelefono().getId())
                .orElseThrow(() -> new RuntimeException("Teléfono no encontrado con el código: " + id));
        telefono.setNumeroTelefono(telefonoSucursal.getCorrelativoTelefono().getNumeroTelefono());
        telefono = telefonoRepository.save(telefono);
        telefonoSucursal1.setCorrelativoTelefono(telefono);
        Sucursal sucursal = sucursalRepository.findById(telefonoSucursal.getCodigoSucursal().getId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con el código: " + telefonoSucursal.getCodigoSucursal().getId()));
        telefonoSucursal1.setCodigoSucursal(sucursal);
        return telefonoSucursalRepository.save(telefonoSucursal1);
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
    public List<TelefonoPersona> getAllTelefonoPersona() {
        return telefonoPersonaRepository.findAll();
    }

    @Override
    public List<TelefonoSucursal> getAllTelefonoSucursal() {
        return telefonoSucursalRepository.findAll();
    }

    @Override
    public List<Telefono> getAllTelefonos() {
        return telefonoRepository.findAll();
    }
}
