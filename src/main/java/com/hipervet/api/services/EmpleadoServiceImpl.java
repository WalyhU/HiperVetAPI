package com.hipervet.api.services;

import com.hipervet.api.entities.Empleado;
import com.hipervet.api.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void save(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        if (empleadoRepository.existsById(id)) {
            empleado.setId(id);
            empleadoRepository.save(empleado);
            return empleado;
        }
        return null;
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado findById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }
}
