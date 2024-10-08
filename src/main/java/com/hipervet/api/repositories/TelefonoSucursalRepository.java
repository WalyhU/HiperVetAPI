package com.hipervet.api.repositories;

import com.hipervet.api.entities.TelefonoSucursal;
import com.hipervet.api.entities.TelefonoSucursalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoSucursalRepository extends JpaRepository<TelefonoSucursal, TelefonoSucursalId> {
}
