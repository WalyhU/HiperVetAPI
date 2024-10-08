package com.hipervet.api.services;

import com.hipervet.api.entities.DetalleDeTratamiento;
import com.hipervet.api.entities.Tratamiento;

import java.util.List;

public interface DetalleDeTratamientoService {
    public DetalleDeTratamiento saveDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento);
    public DetalleDeTratamiento updateDetalleDeTratamiento(Integer id, DetalleDeTratamiento detalleDeTratamiento);
    public void deleteDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento);
    public DetalleDeTratamiento getDetalleDeTratamientoById(Tratamiento id);
    public List<DetalleDeTratamiento> getDetalleDeTratamientos();
    public List<DetalleDeTratamiento> getDetalleDeTratamientosByTratamiento(Tratamiento tratamiento);
}
