package com.hipervet.api.repositories;

import com.hipervet.api.entities.HorarioEmpleado;
import com.hipervet.api.models.EmpleadoFaltas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioEmpleadoRepository extends JpaRepository<HorarioEmpleado, Long> {
    @Query("SELECT h FROM HorarioEmpleado h WHERE h.empleado.id = ?1")
    public List<HorarioEmpleado> findByEmpleadoId(Long empleadoId);
    @Query("SELECT new com.hipervet.api.models.EmpleadoFaltas(e.id, p.primerNombre, p.primerApellido, COUNT(h)) " +
            "FROM HorarioEmpleado h " +
            "JOIN h.empleado e " +
            "JOIN e.codigoPersona p " +
            "WHERE MONTH(h.fecha) = :mes AND YEAR(h.fecha) = :anio " +
            "GROUP BY e.id, p.primerNombre, p.primerApellido " +
            "ORDER BY COUNT(h) DESC")
    List<EmpleadoFaltas> findEmpleadoMasFaltas(int mes, int anio);

}
