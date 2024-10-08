package com.hipervet.api.repositories;

import com.hipervet.api.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Short> {
}
