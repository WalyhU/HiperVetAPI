package com.hipervet.api.repositories;

import com.hipervet.api.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Short> {
    public Tratamiento getTratamientoByDescripcion(String descripcion);
}
