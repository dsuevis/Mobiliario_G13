package com.unab.mobiliario.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.mobiliario.Models.Reserva;
import com.unab.mobiliario.Repositories.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

        // Traer todas las reservas
    public List<Reserva> getAllReserva() {
        return reservaRepository.getAll();
    }

    // Traer por un id
    public Optional<Reserva> getReserva(int idReserva) {
        return reservaRepository.getReserva(idReserva);
    }

    // Traer reservas por fecha
    public Optional<Reserva> getReservaByFecha(Date fechaReserva) {
        return reservaRepository.getAllByDatesR(fechaReserva);
    }

     // Traer devoluciones por fecha
    public Optional<Reserva> getDevolucionesByFecha(Date fechaDevolucion) {
        return reservaRepository.getAllByDatesD(fechaDevolucion);
    }

    // Guardar
    public Reserva insertReserva(Reserva reserva) {
        if (reserva.getIdReserva() == null)
            // Campos obligatorios
            if (reserva.getFechaRecogida() != null && reserva.getFechaDevolucion() != null )
                return reservaRepository.save(reserva);
            else
                return reserva;
        else
            return reserva;
    }

    // Actualizar
    public Reserva updateReserva(Reserva reserva) {
        if (reserva.getIdReserva() != null) {
            // verificación de que el id exista en base de datos
            Optional<Reserva> temp = reservaRepository.getReserva(reserva.getIdReserva());
            if (!temp.isEmpty()) {
                if (reserva.getFechaDevolucion() != null)
                    temp.get().setFechaDevolucion(reserva.getFechaDevolucion());
                if (reserva.getFechaRecogida() != null)
                    temp.get().setFechaRecogida(reserva.getFechaRecogida());
                if (reserva.getStatus() != null)
                    temp.get().setStatus(reserva.getStatus());
                if (reserva.getMobiliario() != null)
                    temp.get().setMobiliario(reserva.getMobiliario());
                if (reserva.getCliente() != null)
                    temp.get().setCliente(reserva.getCliente());
                return reservaRepository.save(temp.get());
            } else
                return reserva;
        } else
            return reserva;
    }

    // Eliminar
    public boolean deleteReserva(int IdReserva) {
        Boolean success = getReserva(IdReserva).map(reserva -> {
            reservaRepository.delete(reserva);
            return true;
        }).orElse(false);
        return success;
    }
    
}
