package com.unab.mobiliario.Models;

import java.io.Serializable;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {

    //Atributos
    @Id
    @Column(name="idCategoria")
    private Integer idCategoria;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;


    //Relaciones
   // @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="categoria")
   // @JsonIgnoreProperties("categoria")
   // private Set <Mobiliario> mobiliarios; 


    
}
