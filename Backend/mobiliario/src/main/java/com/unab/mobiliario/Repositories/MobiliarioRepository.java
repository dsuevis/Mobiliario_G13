package com.unab.mobiliario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.mobiliario.Models.Mobiliario;
import com.unab.mobiliario.Repositories.CRUDRepository.MobiliarioCrudRepository;

@Repository
public class MobiliarioRepository {

    @Autowired
    private MobiliarioCrudRepository mobiliarioCrudRepository;

    //Función para traer todos los mobiliarios
    public List<Mobiliario> getAll(){
        return (List<Mobiliario>) mobiliarioCrudRepository.findAll();        
    }

    //Función para buscar por código
    public Optional<Mobiliario> getMobiliario (int idMobiliario){
        return mobiliarioCrudRepository.findById(idMobiliario);
    }

    //Función para buscar por nombres
    //public Optional<Mobiliario> getMobiliarioByName (String nombre){
     //   return mobiliarioCrudRepository.findByName(nombre);
    //}

    //Función para guardar 
    public Mobiliario save(Mobiliario mobiliario){
        return mobiliarioCrudRepository.save(mobiliario);
    }

    //Función para eliminar
    public void delete(Mobiliario mobiliario){
        mobiliarioCrudRepository.delete(mobiliario);
    }

    
}
