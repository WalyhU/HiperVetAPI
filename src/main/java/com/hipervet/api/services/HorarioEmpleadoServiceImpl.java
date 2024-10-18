package com.hipervet.api.services;

import com.hipervet.api.entities.HorarioEmpleado;
import com.hipervet.api.repositories.HorarioEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioEmpleadoServiceImpl implements HorarioEmpleadoService {

    @Autowired
    private HorarioEmpleadoRepository horarioEmpleadoRepository;

    @Override
    public HorarioEmpleado registrarHorario(HorarioEmpleado horarioEmpleado) {
        horarioEmpleado.setCorrelativoHorario(generarCorrelativoHorario());
        return horarioEmpleadoRepository.save(horarioEmpleado);
    }

    @Override
    public List<HorarioEmpleado> obtenerHorariosPorEmpleado(Long idEmpleado) {
        return horarioEmpleadoRepository.findByEmpleadoId(idEmpleado);
    }

    @Override
    public List<HorarioEmpleado> obtenerHorarios() {
        return horarioEmpleadoRepository.findAll();
    }

    @Override
    public HorarioEmpleado actualizarHorario(Long id, HorarioEmpleado horarioEmpleado) {
        horarioEmpleado.setCorrelativoHorario(id);
        return horarioEmpleadoRepository.save(horarioEmpleado);
    }

    @Override
    public void eliminarHorario(Long id) {
        horarioEmpleadoRepository.deleteById(id);
    }

    private Long generarCorrelativoHorario() {
        return horarioEmpleadoRepository.count() + 1;
    }
}
