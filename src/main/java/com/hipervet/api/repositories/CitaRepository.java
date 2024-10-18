package com.hipervet.api.repositories;

import com.hipervet.api.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, String> {
    public List<Cita> findCitasByCodigoSucursal(Sucursal codigoSucursal);
    public List<Cita> findCitasByCodigoCliente(Cliente codigoCliente);
    public List<Cita> findCitasByCodigoEmpleado(Empleado codigoEmpleado);
    public List<Cita> findCitasByFechaCitaBetween(Instant fechaInicio, Instant fechaFin);
}
