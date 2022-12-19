package com.unab.mobiliario.Repositories.CRUDRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unab.mobiliario.Models.Mobiliario;

public interface MobiliarioCrudRepository extends CrudRepository <Mobiliario, Integer> {
    //Customize query methods to search by either name
    public Optional<Mobiliario> findByName(String nombre);
    
}
