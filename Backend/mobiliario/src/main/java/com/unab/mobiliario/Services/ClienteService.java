package com.unab.mobiliario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.mobiliario.Models.Cliente;
import com.unab.mobiliario.Repositories.ClienteRepository;



@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Traer todos los clientes
    public List<Cliente> getAllCliente() {
        return clienteRepository.getAll();
    }

    // Traer por un id
    public Optional<Cliente> getCliente(int idCliente) {
        return clienteRepository.getCliente(idCliente);
    }

    // Traer por nombre
    public Optional<Cliente> getClienteByNombre(String nombres) {
        return clienteRepository.getClienteByName(nombres);
    }

    // Guardar
    public Cliente insertCliente(Cliente cliente) {
        if (cliente.getIdCliente() == null)
            // Campos obligatorios
            if (cliente.getNombres() != null && cliente.getApellidos() != null && cliente.getEmail() != null
                    && cliente.getPassword() != null)
                return clienteRepository.save(cliente);
            else
                return cliente;
        else
            return cliente;
    }

    // Actualizar
    public Cliente updateCliente(Cliente cliente) {
        if (cliente.getIdCliente() != null) {
            // verificación de que el id exista en base de datos
            Optional<Cliente> temp = clienteRepository.getCliente(cliente.getIdCliente());
            if (!temp.isEmpty()) {
                if (cliente.getNombres() != null)
                    temp.get().setNombres(cliente.getNombres());
                if (cliente.getApellidos() != null)
                    temp.get().setApellidos(cliente.getApellidos());
                if (cliente.getEdad() != null)
                    temp.get().setEdad(cliente.getEdad());
                if (cliente.getBarrio() != null)
                    temp.get().setBarrio(cliente.getBarrio());
                if (cliente.getDireccion() != null)
                    temp.get().setDireccion(cliente.getDireccion());
                if (cliente.getEmail() != null)
                    temp.get().setEmail(cliente.getEmail());
                if (cliente.getTelefono() != null)
                    temp.get().setTelefono (cliente.getTelefono());
                if (cliente.getPassword() != null)
                    temp.get().setPassword(cliente.getPassword());
                return clienteRepository.save(temp.get());
            } else
                return cliente;
        } else
            return cliente;
    }

    // Eliminar
    public boolean deleteCliente(int IdCliente) {
        Boolean success = getCliente(IdCliente).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
        return success;
    }
    
}
