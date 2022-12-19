package com.unab.mobiliario.Repositories.CRUDRepository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.unab.mobiliario.Models.Reserva;

public interface ReservaCrudRepository extends CrudRepository <Reserva, Integer>{

        //Customize query methods to search by reservation date and return date
        public Optional<Reserva> findByFechaR (Date fechaReserva);
        public Optional<Reserva> findByFechaD (Date fechaDevolucion);
}
