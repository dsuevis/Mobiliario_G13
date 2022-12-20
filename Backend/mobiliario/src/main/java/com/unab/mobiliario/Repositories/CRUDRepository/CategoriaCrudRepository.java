package com.unab.mobiliario.Repositories.CRUDRepository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unab.mobiliario.Models.Categoria;

public interface CategoriaCrudRepository extends CrudRepository <Categoria, Integer> {
       //Customize query methods to search by either name
      // public Optional<Categoria> findByName(String nombre);
    
}
