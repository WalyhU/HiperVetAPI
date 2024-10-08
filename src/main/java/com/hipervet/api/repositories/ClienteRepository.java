package com.hipervet.api.repositories;

import com.hipervet.api.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @Query("SELECT c FROM Cliente c JOIN Persona p ON c.codigoPersona.id = p.id WHERE p.primerNombre LIKE %?1% OR p.segundoNombre LIKE %?1% OR p.tercerNombre LIKE %?1% OR p.primerApellido LIKE %?1% OR p.segundoApellido LIKE %?1% OR p.tercerApellido LIKE %?1%")
    public List<Cliente> findByNombre(String nombre);
}
