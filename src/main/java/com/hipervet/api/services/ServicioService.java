package com.hipervet.api.services;

import com.hipervet.api.entities.Servicio;

import java.util.List;

public interface ServicioService {
    public Servicio saveServicio(Servicio servicio);
    public void deleteServicio(Servicio servicio);
    public Servicio updateServicio(Short id, Servicio servicio);
    public Servicio getServicioById(Short id);
    public List<Servicio> getAllServicios();
}
