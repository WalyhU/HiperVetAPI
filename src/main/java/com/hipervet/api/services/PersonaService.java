package com.hipervet.api.services;

import com.hipervet.api.entities.Persona;

import java.util.List;

public interface PersonaService {
    public void savePersona(Persona persona);
    public List<Persona> getPersonas();
    public Persona getPersonaById(Integer id);
    public Persona getPersonaByNombre(String primerNombre);
    public void deletePersonaById(Integer id);
    public void updatePersonaById(Integer id, Persona persona);
}
