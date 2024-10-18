package com.hipervet.api.repositories;

import com.hipervet.api.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefonoSucursalRepository extends JpaRepository<TelefonoSucursal, Integer> {
    public void deleteTelefonoSucursalByCorrelativoTelefono(Telefono correlativoTelefono);
    public List<TelefonoSucursal> findAllByCodigoSucursal(Sucursal codigoSucursal);
}
