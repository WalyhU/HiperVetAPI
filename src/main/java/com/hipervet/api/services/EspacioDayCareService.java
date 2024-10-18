package com.hipervet.api.services;

import com.hipervet.api.entities.EspacioDayCare;

import java.util.List;

public interface EspacioDayCareService {
    public EspacioDayCare registrarEspacio(EspacioDayCare espacioDayCare);
    public List<EspacioDayCare> obtenerEspaciosPorTallaPerro(String tallaPerro);
    public EspacioDayCare actualizarEspacio(Long id, Integer espaciosOcupados);
    public List<EspacioDayCare> obtenerEspacios();
}
