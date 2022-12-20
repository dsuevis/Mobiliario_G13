package com.unab.mobiliario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.mobiliario.Models.Mobiliario;
import com.unab.mobiliario.Repositories.MobiliarioRepository;



@Service
public class MobiliarioService {

    @Autowired
    private MobiliarioRepository mobiliarioRepository;

   //Traer todos los mobiliarios
   public List<Mobiliario> getAllMobiliario(){
    return mobiliarioRepository.getAll();
   }

    //Traer una por id
    public Optional<Mobiliario> getMobiliario(int idMobiliario){
        return mobiliarioRepository.getMobiliario(idMobiliario);
    }

    //Traer por nombre
    public Optional<Mobiliario> getMobiliarioByNombre(String nombre){
        return mobiliarioRepository.getMobiliarioByName (nombre);
    }

    //Guardar
    public Mobiliario insertMobiliario(Mobiliario mobiliario){
        if(mobiliario.getIdMobiliario() == null)
            //Campos obligatorios
            if(mobiliario.getMarca() !=null && mobiliario.getNombre() !=null && mobiliario.getPrecio() !=null)
                return mobiliarioRepository.save(mobiliario);
            else
             return mobiliario;
        else
            return mobiliario;
    }

    //Actualizar
    public Mobiliario updateCategoria (Mobiliario  mobiliario) {
        if( mobiliario.getIdMobiliario() != null){
            //verificación de que el id exista en base de datos
            Optional<Mobiliario> temp = mobiliarioRepository.getMobiliario( mobiliario.getIdMobiliario() );
            if( !temp.isEmpty() ){
                if(mobiliario.getNombre() != null)
                    temp.get().setNombre (mobiliario.getNombre());
                if(mobiliario.getMarca() != null)
                    temp.get().setMarca( mobiliario.getMarca());
                if(mobiliario.getPrecio() != null)
                    temp.get().setPrecio( mobiliario.getPrecio());
                if(mobiliario.getColor() != null)
                    temp.get().setColor( mobiliario.getColor());
                if(mobiliario.getCategoria() != null)
                    temp.get().setCategoria( mobiliario.getCategoria());
                if(mobiliario.getNEjemplares() != null)
                    temp.get().setNEjemplares( mobiliario.getNEjemplares());
                return mobiliarioRepository.save(temp.get());
            }
            else
                return  mobiliario;
        }
        else
            return  mobiliario;
    }

    //Eliminar
    public boolean deleteMobiliario(int IdMobiliario){
        Boolean success = getMobiliario(IdMobiliario).map( mobiliario -> {
            mobiliarioRepository.delete( mobiliario);
            return true;
        }).orElse(false);
        return success;
    }
    


    
}
