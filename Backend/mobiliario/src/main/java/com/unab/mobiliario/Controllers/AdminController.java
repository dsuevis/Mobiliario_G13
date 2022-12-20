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

import com.unab.mobiliario.Models.Admin;
import com.unab.mobiliario.Services.AdminService;

@RestController
@RequestMapping ("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    //Traer todos los mobiliarios
    @GetMapping("/all")
    public List<Admin> getAllAdmin(){
     return adminService.getAllAdmin();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int idAdmin){
        return adminService.getAdmin(idAdmin);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin insertAdmin(@RequestBody Admin admin){
            return adminService.insertAdmin(admin);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin (@RequestBody Admin  admin) {
        return adminService.updateAdmin(admin);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable ("id") int IdAdmin){
        return adminService.deleteAdmin(IdAdmin);
    }


}
