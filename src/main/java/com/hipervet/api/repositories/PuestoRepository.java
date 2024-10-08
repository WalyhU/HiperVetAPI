package com.hipervet.api.repositories;

import com.hipervet.api.entities.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuestoRepository extends JpaRepository<Puesto, Short> {
}
