package com.hipervet.api.services;

import com.hipervet.api.entities.FichaMascota;

import java.util.List;
import java.util.Optional;

public interface FichaMascotaService {
    FichaMascota saveFichaMascota(FichaMascota fichaMascota);
    Optional<FichaMascota> getFichaMascotaById(Integer id);
    List<FichaMascota> getAllFichasMascota();
    FichaMascota updateFichaMascota(Integer id, FichaMascota fichaMascota);
    void deleteFichaMascota(Integer id);
}
