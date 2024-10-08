package com.hipervet.api.services;

import com.hipervet.api.entities.Empleado;

import java.util.List;

public interface EmpleadoService {
    public void save(Empleado empleado);
    public void delete(Empleado empleado);
    public Empleado updateEmpleado(Integer id, Empleado empleado);
    public List<Empleado> findAll();
    public Empleado findById(Integer id);
}
