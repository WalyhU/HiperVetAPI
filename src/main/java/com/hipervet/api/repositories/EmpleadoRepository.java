package com.hipervet.api.repositories;

import com.hipervet.api.entities.Empleado;
import com.hipervet.api.entities.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    public List<Empleado> findByCodigoPuesto(Puesto codigoPuesto);
}
