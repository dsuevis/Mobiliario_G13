package com.unab.mobiliario.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.mobiliario.Models.Cliente;
import com.unab.mobiliario.Services.ClienteService;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Traer todos los clientes
    @GetMapping("/all")
    public List<Cliente> getAllCliente(){
     return clienteService.getAllCliente();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int idCliente){
        return clienteService.getCliente(idCliente);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente insertCliente(@RequestBody Cliente cliente){
            return clienteService.insertCliente(cliente);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente (@RequestBody Cliente  cliente) {
        return clienteService.updateCliente(cliente);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCliente(@PathVariable ("id") int IdCliente){
        return clienteService.deleteCliente(IdCliente);
    }


    
}
