package com.unab.mobiliario.Repositories.CRUDRepository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unab.mobiliario.Models.Admin;


public interface AdminCrudRepository extends CrudRepository <Admin, Integer>{
    
    //Customize query methods to search by either name or lastname
    //public Optional<Admin> findByName(String adminNombres);
    //public Optional<Admin> findByLastname(String adminApellidos);
}
