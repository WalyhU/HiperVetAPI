package com.hipervet.api.repositories;

import com.hipervet.api.entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Short> {
}
