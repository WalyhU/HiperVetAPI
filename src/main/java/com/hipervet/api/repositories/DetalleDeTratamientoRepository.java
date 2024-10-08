package com.hipervet.api.repositories;

import com.hipervet.api.entities.DetalleDeTratamiento;
import com.hipervet.api.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleDeTratamientoRepository extends JpaRepository<DetalleDeTratamiento, Integer> {
    public List<DetalleDeTratamiento> findDetalleDeTratamientosByCodigoTratamiento(Tratamiento codigoTratamiento);
}
