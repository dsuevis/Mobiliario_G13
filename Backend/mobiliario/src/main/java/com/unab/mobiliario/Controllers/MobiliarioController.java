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

import com.unab.mobiliario.Models.Mobiliario;
import com.unab.mobiliario.Services.MobiliarioService;

@RestController
@RequestMapping ("/mobiliario")
public class MobiliarioController {

    @Autowired
    private MobiliarioService mobiliarioService;
    
    //Traer todos los mobiliarios
    @GetMapping("/all")
    public List<Mobiliario> getAllMobiliario(){
     return mobiliarioService.getAllMobiliario();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Mobiliario> getMobiliario(@PathVariable("id") int idMobiliario){
        return mobiliarioService.getMobiliario(idMobiliario);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Mobiliario insertMobiliario(@RequestBody Mobiliario mobiliario){
            return mobiliarioService.insertMobiliario(mobiliario);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mobiliario updateMobiliario (@RequestBody Mobiliario  mobiliario) {
        return mobiliarioService.updateMobiliario(mobiliario);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMobiliario(@PathVariable ("id") int IdMobiliario){
        return mobiliarioService.deleteMobiliario(IdMobiliario);
    }


}
