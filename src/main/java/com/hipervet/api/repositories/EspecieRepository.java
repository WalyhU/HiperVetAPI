package com.hipervet.api.repositories;

import com.hipervet.api.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Short> {
}
