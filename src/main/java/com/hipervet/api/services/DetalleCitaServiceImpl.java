package com.hipervet.api.services;

import com.hipervet.api.entities.*;
import com.hipervet.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DetalleCitaServiceImpl implements DetalleCitaService {

    @Autowired
    private DetalleCitaRepository detalleCitaRepository;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private FichaMascotaRepository fichaMascotaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public DetalleCita saveDetalleCita(DetalleCita detalleCita) {
        Cita cita = detalleCita.getCita();
        Sucursal sucursal = sucursalRepository.findById(cita.getCodigoSucursal().getId()).orElse(null);
        Cliente cliente = clienteRepository.findById(cita.getCodigoCliente().getCodigoCliente()).orElse(null);
        Empleado empleado = empleadoRepository.findById(cita.getCodigoEmpleado().getId()).orElse(null);
        FichaMascota fichaMascota = fichaMascotaRepository.findById(detalleCita.getNumeroFicha().getId()).orElse(null);
        Servicio servicio = servicioRepository.findById(detalleCita.getCodigoServicio().getId()).orElse(null);

        if (fichaMascota == null) {
            throw new IllegalArgumentException("Numero ficha cannot be null");
        }

        cita.setCodigoSucursal(sucursal);
        cita.setCodigoCliente(cliente);
        cita.setCodigoEmpleado(empleado);
        Cita newCita = citaRepository.save(cita);

        detalleCita.setNumeroFicha(fichaMascota);
        detalleCita.setCodigoServicio(servicio);
        detalleCita.setCita(newCita);

        return detalleCitaRepository.save(detalleCita);
    }

    @Override
    public void deleteDetalleCita(DetalleCita detalleCita) {
        detalleCitaRepository.delete(detalleCita);
    }

    @Override
    public DetalleCita updateDetalleCita(Integer detalleCitaId, DetalleCita detalleCita) {
        if (detalleCitaRepository.existsById(detalleCitaId)) {
            // Actualizar la cita asociada al detalle de la cita
            if (citaRepository.existsById(detalleCita.getCita().getId())) {
                Cita cita = detalleCita.getCita();
                Sucursal sucursal = sucursalRepository.getReferenceById(cita.getCodigoSucursal().getId());
                Cliente cliente = clienteRepository.getReferenceById(cita.getCodigoCliente().getCodigoCliente());
                Empleado empleado = empleadoRepository.getReferenceById(cita.getCodigoEmpleado().getId());
                cita.setCodigoSucursal(sucursal);
                cita.setCodigoCliente(cliente);
                cita.setCodigoEmpleado(empleado);
                Cita newCita = citaRepository.save(cita);
                detalleCita.setCita(newCita);
            }
            detalleCita.setId(detalleCitaId);
            detalleCitaRepository.save(detalleCita);
            return detalleCita;
        }
        return null;
    }

    @Override
    public List<DetalleCita> getDetalleCitas() {
        return detalleCitaRepository.findAll();
    }

    @Override
    public DetalleCita getDetalleCitaById(Integer id) {
        return detalleCitaRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByCita(Cita cita) {
        return detalleCitaRepository.findDetalleCitasByCita(cita);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByServicio(Servicio servicio) {
        return detalleCitaRepository.findDetalleCitasByCodigoServicio(servicio);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByEmpleado(Empleado empleado) {
        return detalleCitaRepository.findDetalleCitasByCodigoEmpleado(empleado);
    }

    @Override
    public List<DetalleCita> getDetalleCitasByFechaBetween(Instant fechaInicio, Instant fechaFin) {
        return detalleCitaRepository.findDetalleCitasByInicioBetween(fechaInicio, fechaFin);
    }

    @Override
    public String getCorrelativo() {
        return String.format("CI%d-%d", detalleCitaRepository.count(), Instant.now().getEpochSecond());
    }
}
