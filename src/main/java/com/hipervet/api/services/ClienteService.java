package com.hipervet.api.services;

import com.hipervet.api.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public Cliente saveCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente);
    public Cliente updateCliente(String codigoCliente, Cliente cliente);
    public List<Cliente> getClientes();
    public Optional<Cliente> getClienteById(String id);
    public List<Cliente> getClienteByNombre(String nombre);
}
