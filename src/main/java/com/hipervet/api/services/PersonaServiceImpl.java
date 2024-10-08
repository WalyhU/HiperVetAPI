package com.hipervet.api.services;

import com.hipervet.api.entities.Persona;
import com.hipervet.api.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(Integer id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona getPersonaByNombre(String primerNombre) {
        return personaRepository.findByPrimerNombre(primerNombre);
    }

    @Override
    public void deletePersonaById(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void updatePersonaById(Integer id, Persona persona) {
        if (personaRepository.existsById(id)) {
            persona.setId(id);
            personaRepository.save(persona);
        }
    }
}
