package com.unab.mobiliario.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="reserva")

public class Reserva implements Serializable {

    //Atributos
    @Id
    @Column(name="idReserva")
    private Integer idReserva;
    @Column(name="fechaRecogida")
    private Date fechaRecogida;
    @Column(name="fechaDevolución")
    private Date fechaDevolucion;
    @Column(name="status")
    private String status = "Creada";

    //Relaciones
    @ManyToOne
    @JoinColumn(name="idMobiliario")
    @JsonIgnoreProperties("reservas")
    private Mobiliario mobiliario;


    @ManyToOne
    @JoinColumn(name="idCliente")
    @JsonIgnoreProperties("reservas")
    private Cliente cliente;
    
}
