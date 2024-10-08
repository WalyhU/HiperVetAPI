package com.hipervet.api.repositories;

import com.hipervet.api.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    public Persona findByPrimerNombre(String primerNombre);
}
