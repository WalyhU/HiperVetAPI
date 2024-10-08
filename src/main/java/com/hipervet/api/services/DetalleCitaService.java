package com.hipervet.api.services;

import com.hipervet.api.entities.*;

import java.time.Instant;
import java.util.List;

public interface DetalleCitaService {
    public DetalleCita saveDetalleCita(DetalleCita detalleCita);
    public void deleteDetalleCita(DetalleCita detalleCita);
    public DetalleCita updateDetalleCita(DetalleCitaId detalleCitaId, DetalleCita detalleCita);
    public List<DetalleCita> getDetalleCitas();
    public DetalleCita getDetalleCitaById(DetalleCitaId id);
    public List<DetalleCita> getDetalleCitasByCita(Cita cita);
    public List<DetalleCita> getDetalleCitasByServicio(Servicio servicio);
    public List<DetalleCita> getDetalleCitasByEmpleado(Empleado empleado);
    public List<DetalleCita> getDetalleCitasByFechaBetween(Instant fechaInicio, Instant fechaFin);
}
