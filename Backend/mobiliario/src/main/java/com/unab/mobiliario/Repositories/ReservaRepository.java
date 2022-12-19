package com.unab.mobiliario.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.mobiliario.Models.Reserva;
import com.unab.mobiliario.Repositories.CRUDRepository.ReservaCrudRepository;

@Repository
public class ReservaRepository  {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    //Función para traer todas las reservas
    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();        
    }

    //Función para buscar por código
    public Optional<Reserva> getReserva (int idReserva){
        return reservaCrudRepository.findById(idReserva);
    }

    //Función para buscar una reserva por fecha
    public Optional<Reserva> getAllByDatesR(Date fechaReserva){
        return reservaCrudRepository.findByFechaR(fechaReserva);
    }

    //Función para buscar una devolución por fecha
    public Optional<Reserva> getAllByDatesD (Date fechaDevolucion){
        return reservaCrudRepository.findByFechaD(fechaDevolucion);
    }   

    //Función para guardar 
    public Reserva save(Reserva reserva){
        return reservaCrudRepository.save(reserva);
    }

    //Función para eliminar
    public void delete(Reserva reserva){
        reservaCrudRepository.delete(reserva);
    }

    
}
