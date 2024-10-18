package com.hipervet.api.services;

import com.hipervet.api.entities.Empleado;
import com.hipervet.api.entities.Persona;
import com.hipervet.api.entities.Puesto;
import com.hipervet.api.repositories.EmpleadoRepository;
import com.hipervet.api.repositories.PersonaRepository;
import com.hipervet.api.repositories.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PuestoRepository puestoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        Persona newPersona = personaRepository.save(empleado.getCodigoPersona());
        empleado.setCodigoPersona(newPersona);
        empleado.setCodigoPuesto(puestoRepository.findById(empleado.getCodigoPuesto().getId()).orElse(null));
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    @Override
    public Empleado updateEmpleado(String id, Empleado empleado) {
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
    public Empleado findById(String id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Empleado> findByPuesto(Puesto id) {
        return empleadoRepository.findByCodigoPuesto(id);
    }
}
