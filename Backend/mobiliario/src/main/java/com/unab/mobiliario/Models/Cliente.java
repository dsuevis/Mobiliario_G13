package com.unab.mobiliario.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")

public class Cliente implements Serializable {

       //Atributos
       @Id
       @Column(name="idCliente")
       private Integer idCliente;
       @Column(name="nombres")
       private String nombres;
       @Column(name="apellidos")
       private String apellidos;
       @Column(name="edad")
       private Integer edad;
       @Column(name="barrio")
       private String barrio;
       @Column(name="direccion")
       private String direccion;
       @Column(name="email")
       private String email;
       @Column(name="telefono")
       private Integer telefono;
       @Column(name="password")
       private String password;


       //Relaciones
       @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cliente")
       @JsonIgnoreProperties("cliente")
       private Set<Reserva> reservas;      

    
}
