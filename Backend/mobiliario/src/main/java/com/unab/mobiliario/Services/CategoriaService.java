package com.unab.mobiliario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.mobiliario.Models.Categoria;
import com.unab.mobiliario.Repositories.CategoriaRepository;



@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Traer todas las categorias
    public List<Categoria> getAllCategoria(){
        return categoriaRepository.getAll();
    }

    //Traer una por id
    public Optional<Categoria> getCategoria(int idCategoria){
        return categoriaRepository.getCategoria(idCategoria);
    }

    //Traer por nombre
    //public Optional<Categoria> getCategoriaByNombre(String nombre){
     //   return categoriaRepository.getCategoriaByName (nombre);
    //}

    //Guardar
    public Categoria insertCategoria(Categoria categoria){
        if(categoria.getIdCategoria() == null)
            //Campos obligatorios
            if(categoria.getDescripcion() !=null && categoria.getNombre() !=null)
                return categoriaRepository.save(categoria);
            else
             return categoria;
        else
            return categoria;
    }

    //Actualizar
    public Categoria updateCategoria (Categoria categoria) {
        if(categoria.getIdCategoria() != null){
            //verificación de que el id exista en base de datos
            Optional<Categoria> temp = categoriaRepository.getCategoria( categoria.getIdCategoria() );
            if( !temp.isEmpty() ){
                if(categoria.getNombre() != null)
                    temp.get().setNombre (categoria.getNombre());
                if(categoria.getDescripcion() != null)
                    temp.get().setDescripcion( categoria.getDescripcion());
                return categoriaRepository.save(temp.get());
            }
            else
                return categoria;
        }
        else
            return categoria;
    }

    //Eliminar
    public boolean deleteCategoria(int IdCategoria){
        Boolean success = getCategoria(IdCategoria).map(categoria -> {
            categoriaRepository.delete(categoria);
            return true;
        }).orElse(false);
        return success;
    }
    
}
