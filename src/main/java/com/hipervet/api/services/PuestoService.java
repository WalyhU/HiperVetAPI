package com.hipervet.api.services;

import com.hipervet.api.entities.Puesto;

import java.util.List;

public interface PuestoService {
    public Puesto savePuesto(Puesto puesto);
    public List<Puesto> getPuestos();
    public Puesto getPuestoById(Short id);
    public void deletePuestoById(Short id);
    public Puesto updatePuestoById(Short id, Puesto puesto);
}
