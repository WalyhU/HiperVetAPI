package com.hipervet.api.repositories;

import com.hipervet.api.entities.EspacioDayCare;
import com.hipervet.api.models.OcupacionDayCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EspacioDayCareRepository extends JpaRepository<EspacioDayCare, Long> {
    List<EspacioDayCare> findByTallaPerro(String tallaPerro);
}
