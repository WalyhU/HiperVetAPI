package com.hipervet.api.services;

import com.hipervet.api.entities.Raza;

import java.util.List;

public interface RazaService {
    public Raza saveRaza(Raza raza);
    public List<Raza> getRazas();
    public Raza getRazaById(Short id);
    public void deleteRazaById(Short id);
    public Raza updateRazaById(Short id, Raza raza);
}
