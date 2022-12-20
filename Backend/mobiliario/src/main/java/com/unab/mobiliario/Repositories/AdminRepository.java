package com.unab.mobiliario.Repositories;

import com.unab.mobiliario.Models.Admin;
import com.unab.mobiliario.Repositories.CRUDRepository.AdminCrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    //Función para traer todos los administradores
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();        
    }

    //Función para buscar por código
    public Optional<Admin> getAdmin (int idAdmin){
        return adminCrudRepository.findById(idAdmin);
    }

    //Función para buscar por nombres
    public Optional<Admin> getAdminByName (String nombres){
        return adminCrudRepository.findByName(nombres);
    }

    //Función para buscar por Apellidos
    public Optional<Admin> getAdminByLastname (String apellidos){
        return adminCrudRepository.findByLastname(apellidos);
    }

    //Función para guardar 
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }

    //Función para eliminar
    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }


    
}
