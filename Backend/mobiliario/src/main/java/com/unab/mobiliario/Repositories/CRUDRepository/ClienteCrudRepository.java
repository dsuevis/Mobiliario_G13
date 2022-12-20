package com.unab.mobiliario.Repositories.CRUDRepository;

//import java.util.Optional; 

import org.springframework.data.repository.CrudRepository;
import com.unab.mobiliario.Models.Cliente;

public interface ClienteCrudRepository extends CrudRepository <Cliente, Integer> {
        //Customize query methods to search an client by either name or lastname
       // public Optional<Cliente> findByName(String nombres);
        //public Optional<Cliente> findByLastname(String apellidos);
    
}
