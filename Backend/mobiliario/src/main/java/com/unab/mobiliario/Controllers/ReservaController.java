package com.unab.mobiliario.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.mobiliario.Models.Reserva;
import com.unab.mobiliario.Services.ReservaService;

@RestController
@RequestMapping ("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    //Traer todas las reservas
    @GetMapping("/all")
    public List<Reserva> getAllReserva(){
     return reservaService.getAllReserva();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("id") int idReserva){
        return reservaService.getReserva(idReserva);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva insertReserva(@RequestBody Reserva reserva){
            return reservaService.insertReserva(reserva);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva updateReserva (@RequestBody Reserva reserva) {
        return reservaService.updateReserva(reserva);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReserva (@PathVariable ("id") int IdReserva){
        return reservaService.deleteReserva(IdReserva);
    }


    
}
