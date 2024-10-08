package com.hipervet.api.services;

import com.hipervet.api.entities.Tratamiento;

import java.util.List;

public interface TratamientoService {
    public void saveTratamiento(Tratamiento tratamiento);
    public void deleteTratamiento(Tratamiento tratamiento);
    public void updateTratamiento(Short id, Tratamiento tratamiento);
    public Tratamiento getTratamientoById(Short id);
    public Tratamiento getTratamientoByDescripcion(String descripcion);
    public List<Tratamiento> getAllTratamientos();
}
