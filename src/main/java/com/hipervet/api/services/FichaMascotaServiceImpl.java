package com.hipervet.api.services;

import com.hipervet.api.entities.FichaMascota;
import com.hipervet.api.repositories.FichaMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaMascotaServiceImpl implements FichaMascotaService {

    @Autowired
    private FichaMascotaRepository fichaMascotaRepository;

    @Override
    public FichaMascota saveFichaMascota(FichaMascota fichaMascota) {
        // Lógica adicional de validación o procesamiento previo
        return fichaMascotaRepository.save(fichaMascota);
    }

    @Override
    public Optional<FichaMascota> getFichaMascotaById(Integer id) {
        // Buscar la ficha de la mascota por ID
        return fichaMascotaRepository.findById(id);
    }

    @Override
    public List<FichaMascota> getAllFichasMascota() {
        // Obtener todas las fichas de mascotas
        return fichaMascotaRepository.findAll();
    }

    @Override
    public FichaMascota updateFichaMascota(Integer id, FichaMascota fichaMascota) {
        Optional<FichaMascota> existingFichaMascota = fichaMascotaRepository.findById(id);

        if (existingFichaMascota.isPresent()) {
            // Lógica adicional para actualizar la ficha de mascota
            FichaMascota fichaToUpdate = existingFichaMascota.get();
            fichaToUpdate.setNombre(fichaMascota.getNombre());
            fichaToUpdate.setCodigoEspecie(fichaMascota.getCodigoEspecie());
            fichaToUpdate.setCodigoRaza(fichaMascota.getCodigoRaza());
            fichaToUpdate.setFechaNacimiento(fichaMascota.getFechaNacimiento());
            fichaToUpdate.setTalla(fichaMascota.getTalla());
            // Otros campos necesarios
            return fichaMascotaRepository.save(fichaToUpdate);
        } else {
            // Manejar el caso donde la ficha no existe
            return null; // o puedes lanzar una excepción personalizada
        }
    }

    @Override
    public void deleteFichaMascota(Integer id) {
        fichaMascotaRepository.deleteById(id);
    }
}
