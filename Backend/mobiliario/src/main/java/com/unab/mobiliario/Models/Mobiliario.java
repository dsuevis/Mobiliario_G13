package com.unab.mobiliario.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="mobiliario")
public class Mobiliario implements Serializable {

    //Atributos
    @Id
    @Column(name="idMobiliario")
    private Integer idMobiliario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="marca")
    private String marca;
    @Column(name="precio")
    private Integer precio;
    @Column(name="color")
    private String color;
    @Column(name="idCategoria")
    private String idCategoria;
    @Column(name="nEjemplares")
    private Integer nEjemplares;

    //Relaciones
    //@ManyToOne 
    //@JoinColumn(name="idCategoria")
    //@JsonIgnoreProperties("mobiliarios")
    //private Categoria Categoria; 

    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="mobiliario")
    @JsonIgnoreProperties("mobiliario")
    private Set<Reserva> reservas;

    
}
