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

import com.unab.mobiliario.Models.Categoria;
import com.unab.mobiliario.Services.CategoriaService;

@RestController
@RequestMapping ("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //Traer todos los mobiliarios
    @GetMapping("/all")
    public List<Categoria> getAllCategoria(){
     return categoriaService.getAllCategoria();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int idCategoria){
        return categoriaService.getCategoria(idCategoria);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria insertCategoria(@RequestBody Categoria categoria){
            return categoriaService.insertCategoria(categoria);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria updateCategoria (@RequestBody Categoria  categoria) {
        return categoriaService.updateCategoria(categoria);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategoria(@PathVariable ("id") int IdCategoria){
        return categoriaService.deleteCategoria(IdCategoria);
    }


    
}
