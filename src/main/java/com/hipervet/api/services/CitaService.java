package com.hipervet.api.services;

import com.hipervet.api.entities.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    public void saveCita(Cita cita);
    public void deleteCita(Cita cita);
    public List<Cita> getCitas();
    public Optional<Cita> getCitaById(CitaId id);
    public Cita updateCita(CitaId id, Cita citaDetails);
    public List<Cita> getCitasBySucursal(Sucursal sucursal);
    public List<Cita> getCitasByCliente(Cliente cliente);
    public List<Cita> getCitasByEmpleado(Empleado empleado);
    public List<Cita> getCitasByFechaBetween(Instant fechaInicio, Instant fechaFin);
}
