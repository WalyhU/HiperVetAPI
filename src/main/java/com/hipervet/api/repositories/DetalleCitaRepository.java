package com.hipervet.api.repositories;

import com.hipervet.api.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface DetalleCitaRepository extends JpaRepository<DetalleCita, DetalleCitaId> {
    public List<DetalleCita> findDetalleCitasByCita(Cita cita);
    public List<DetalleCita> findDetalleCitasByCodigoServicio(Servicio servicio);
    public List<DetalleCita> findDetalleCitasByCodigoEmpleado(Empleado codigoEmpleado);
    public List<DetalleCita> findDetalleCitasByInicioBetween(Instant inicio, Instant inicio2);
}
