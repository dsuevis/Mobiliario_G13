package com.unab.mobiliario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.mobiliario.Models.Categoria;
import com.unab.mobiliario.Repositories.CRUDRepository.CategoriaCrudRepository;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    //Función para traer todas las categorias
    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();        
    }

    //Función para buscar por código
    public Optional<Categoria> getCategoria (int idCategoria){
        return categoriaCrudRepository.findById(idCategoria);
    }

    //Función para buscar por nombre
    public Optional<Categoria> getCategoriaByName (String nombre){
        return categoriaCrudRepository.findByName(nombre);
    }

    //Función para guardar 
    public Categoria save(Categoria categoria){
        return categoriaCrudRepository.save(categoria);
    }

    //Función para eliminar
    public void delete(Categoria categoria){
        categoriaCrudRepository.delete(categoria);
    }
    
}
