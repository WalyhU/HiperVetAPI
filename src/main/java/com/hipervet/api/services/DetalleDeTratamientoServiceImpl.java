package com.hipervet.api.services;

import com.hipervet.api.entities.*;
import com.hipervet.api.repositories.*;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleDeTratamientoServiceImpl implements DetalleDeTratamientoService {

    @Autowired
    private DetalleDeTratamientoRepository detalleDeTratamientoRepository;
    @Autowired
    private TratamientoRepository tratamientoRepository;
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private DetalleCitaRepository detalleCitaRepository;
    @Autowired
    private DetalleDiagnosticoRepository detalleDiagnosticoRepository;
    @Autowired
    private FichaMascotaRepository fichaMascotaRepository;
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public DetalleDeTratamiento saveDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento) {
        DetalleDiagnostico detalleDiagnostico = detalleDiagnosticoRepository.findById(detalleDeTratamiento.getCodigoDiagnostico().getCodigoDetalleDiagnostico()).orElseThrow(
                () -> new RuntimeException("Detalle de diagnóstico no encontrado")
        );
        DetalleCita detalleCita = detalleCitaRepository.findById(detalleDiagnostico.getDetalleCita().getId()).orElseThrow(
                () -> new RuntimeException("Detalle de cita no encontrado")
        );
        Cita cita = citaRepository.findById(detalleCita.getCita().getId()).orElseThrow(
                () -> new RuntimeException("Cita no encontrada")
        );
        FichaMascota fichaMascota = fichaMascotaRepository.findById(detalleCita.getNumeroFicha().getId()).orElseThrow(
                () -> new RuntimeException("Ficha de mascota no encontrada")
        );
        Sucursal sucursal = sucursalRepository.findById(cita.getCodigoSucursal().getId()).orElseThrow(
                () -> new RuntimeException("Sucursal no encontrada")
        );
        Tratamiento tratamiento = detalleDeTratamiento.getCodigoTratamiento();
        Tratamiento newTratamiento = tratamientoRepository.save(tratamiento);
        detalleDeTratamiento.setCodigoDiagnostico(detalleDeTratamiento.getCodigoDiagnostico());
        detalleDeTratamiento.setCodigoTratamiento(newTratamiento);
        detalleDeTratamiento.setCodigoSucursal(sucursal);
        detalleDeTratamiento.setNumeroFicha(fichaMascota);
        detalleDeTratamiento.setNumeroCita(cita);
        detalleDeTratamiento.setCorrelativo(detalleCita);
        return detalleDeTratamientoRepository.save(detalleDeTratamiento);
    }

    @Override
    public DetalleDeTratamiento updateDetalleDeTratamiento(Integer id, DetalleDeTratamiento detalleDeTratamiento) {
        if (detalleDeTratamientoRepository.existsById(id)) {
            tratamientoRepository.save(detalleDeTratamiento.getCodigoTratamiento());
            detalleDeTratamiento.setCodigoDetalleTratamiento(id);
            return detalleDeTratamientoRepository.save(detalleDeTratamiento);
        }
        return null;
    }

    @Override
    public void deleteDetalleDeTratamiento(DetalleDeTratamiento detalleDeTratamiento) {
        if (detalleDeTratamientoRepository.existsById(detalleDeTratamiento.getCodigoDetalleTratamiento())) {
            detalleDeTratamientoRepository.delete(detalleDeTratamiento);
            tratamientoRepository.delete(detalleDeTratamiento.getCodigoTratamiento());
        }
    }

    @Override
    public DetalleDeTratamiento getDetalleDeTratamientoById(Integer id) {
        return detalleDeTratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleDeTratamiento> getDetalleDeTratamientos() {
        return detalleDeTratamientoRepository.findAll();
    }

    @Override
    public List<DetalleDeTratamiento> getDetalleDeTratamientosByTratamiento(Tratamiento tratamiento) {
        return detalleDeTratamientoRepository.findDetalleDeTratamientosByCodigoTratamiento(tratamiento);
    }
}
