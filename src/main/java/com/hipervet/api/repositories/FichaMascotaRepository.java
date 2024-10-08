package com.hipervet.api.repositories;

import com.hipervet.api.entities.FichaMascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaMascotaRepository extends JpaRepository<FichaMascota, Integer> {
}
