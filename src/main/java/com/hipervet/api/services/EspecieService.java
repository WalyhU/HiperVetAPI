package com.hipervet.api.services;

import com.hipervet.api.entities.Especie;

import java.util.List;

public interface EspecieService {
    public List<Especie> listarEspecies();
    public Especie buscarEspeciePorId(Short id);
    public Especie salvarEspecie(Especie especie);
    public void eliminarEspecie(Short id);
    public Especie atualizarEspecie(Short id, Especie especie);
}
