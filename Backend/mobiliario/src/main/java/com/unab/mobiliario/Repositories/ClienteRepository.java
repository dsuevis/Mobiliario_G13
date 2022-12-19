package com.unab.mobiliario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.mobiliario.Models.Cliente;
import com.unab.mobiliario.Repositories.CRUDRepository.ClienteCrudRepository;

@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    //Función para traer todos los clientes
    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();        
    }

    //Función para buscar por código
    public Optional<Cliente> getCliente (int idCliente){
        return clienteCrudRepository.findById(idCliente);
    }

    //Función para buscar por nombres
    public Optional<Cliente> getClienteByName (String nombres){
        return clienteCrudRepository.findByName(nombres);
    }

    //Función para buscar por Apellidos
    public Optional<Cliente> getClienteByLastname (String apellidos){
        return clienteCrudRepository.findByLastname(apellidos);
    }

    //Función para guardar 
    public Cliente save(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }

    //Función para eliminar
    public void delete(Cliente cliente){
        clienteCrudRepository.delete(cliente);
    }
    
}
