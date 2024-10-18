package com.hipervet.api.repositories;

import com.hipervet.api.entities.Persona;
import com.hipervet.api.entities.Telefono;
import com.hipervet.api.entities.TelefonoPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefonoPersonaRepository extends JpaRepository<TelefonoPersona, Integer> {
    public void deleteTelefonoPersonaByCorrelativoTelefono(Telefono correlativoTelefono);
    public List<TelefonoPersona> findAllByCodigoPersona(Persona codigoPersona);
}
