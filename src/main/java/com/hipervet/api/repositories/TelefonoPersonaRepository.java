package com.hipervet.api.repositories;

import com.hipervet.api.entities.TelefonoPersona;
import com.hipervet.api.entities.TelefonoPersonaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoPersonaRepository extends JpaRepository<TelefonoPersona, TelefonoPersonaId> {
}
