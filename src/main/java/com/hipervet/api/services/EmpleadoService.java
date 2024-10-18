package com.hipervet.api.services;

import com.hipervet.api.entities.Empleado;
import com.hipervet.api.entities.Puesto;

import java.util.List;

public interface EmpleadoService {
    public Empleado save(Empleado empleado);
    public void delete(Empleado empleado);
    public Empleado updateEmpleado(String id, Empleado empleado);
    public List<Empleado> findAll();
    public Empleado findById(String id);
    public List<Empleado> findByPuesto(Puesto id);
}
