package com.hipervet.api.services;

import com.hipervet.api.entities.HorarioEmpleado;

import java.util.List;

public interface HorarioEmpleadoService {
    public HorarioEmpleado registrarHorario(HorarioEmpleado horarioEmpleado);
    public List<HorarioEmpleado> obtenerHorariosPorEmpleado(Long idEmpleado);
    public List<HorarioEmpleado> obtenerHorarios();
    public HorarioEmpleado actualizarHorario(Long id, HorarioEmpleado horarioEmpleado);
    public void eliminarHorario(Long id);
}
