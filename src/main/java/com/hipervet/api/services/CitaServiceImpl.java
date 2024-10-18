package com.hipervet.api.services;

import com.hipervet.api.entities.*;
import com.hipervet.api.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void deleteCita(Cita cita) {
        citaRepository.delete(cita);
    }

    @Override
    public List<Cita> getCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Optional<Cita> getCitaById(String id) {
        return citaRepository.findById(id);
    }

    @Override
    public Cita updateCita(String id, Cita citaDetails) {
        if (citaRepository.existsById(id)) {
            citaDetails.setId(id);
            return citaRepository.save(citaDetails);
        }
        return null;
    }

    @Override
    public List<Cita> getCitasBySucursal(Sucursal sucursal) {
        return citaRepository.findCitasByCodigoSucursal(sucursal);
    }

    @Override
    public List<Cita> getCitasByCliente(Cliente cliente) {
        return citaRepository.findCitasByCodigoCliente(cliente);
    }

    @Override
    public List<Cita> getCitasByEmpleado(Empleado empleado) {
        return citaRepository.findCitasByCodigoEmpleado(empleado);
    }

    @Override
    public List<Cita> getCitasByFechaBetween(Instant fechaInicio, Instant fechaFin) {
        return citaRepository.findCitasByFechaCitaBetween(fechaInicio, fechaFin);
    }
}
