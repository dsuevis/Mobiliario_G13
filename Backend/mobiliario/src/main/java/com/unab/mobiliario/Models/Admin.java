package com.unab.mobiliario.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="admin")
public class Admin implements Serializable {
     //Atributos
     @Id
     @Column(name="idAdmin")
     private Integer idAdmin;
     @Column(name="nombres")
     private String adminNombres;
     @Column(name="apellidos")
     private String adminApellidos;
     @Column(name="email")
     private String adminEmail;
     @Column(name="password")
     private String AdminPassword;
    
}
