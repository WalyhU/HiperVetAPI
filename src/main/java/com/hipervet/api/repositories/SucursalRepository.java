package com.hipervet.api.repositories;

import com.hipervet.api.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Short> {
}
