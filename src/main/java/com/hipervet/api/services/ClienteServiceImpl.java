package com.hipervet.api.services;

import com.hipervet.api.entities.Cliente;
import com.hipervet.api.entities.Persona;
import com.hipervet.api.repositories.ClienteRepository;
import com.hipervet.api.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        Persona newPersona = personaRepository.save(cliente.getCodigoPersona());
        cliente.setCodigoPersona(newPersona);
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
        personaRepository.delete(cliente.getCodigoPersona());
    }

    @Override
    public Cliente updateCliente(String codigoCliente, Cliente cliente) {
        if (clienteRepository.existsById(codigoCliente)) {
            Persona newPersona = personaRepository.save(cliente.getCodigoPersona());
            cliente.setCodigoPersona(newPersona);
            cliente.setCodigoCliente(codigoCliente);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getClienteByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
