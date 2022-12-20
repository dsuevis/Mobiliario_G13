package com.unab.mobiliario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.unab.mobiliario.Models.Admin;
import com.unab.mobiliario.Repositories.AdminRepository;

public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Traer todas los administradores
    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    // Traer una por id
    public Optional<Admin> getAdmin(int idAdmin) {
        return adminRepository.getAdmin(idAdmin);
    }

    // Traer por nombre
    public Optional<Admin> getAdminByNombre(String nombre) {
        return adminRepository.getAdminByName(nombre);
    }

    // Guardar
    public Admin insertAdmin(Admin admin) {
        if (admin.getIdAdmin() == null)
            // Campos obligatorios
            if (admin.getAdminNombres() != null && admin.getAdminApellidos() != null && admin.getAdminEmail() != null
                    && admin.getAdminPassword() != null)
                return adminRepository.save(admin);
            else
                return admin;
        else
            return admin;
    }

    // Actualizar
    public Admin updateAdmin(Admin admin) {
        if (admin.getIdAdmin() != null) {
            // verificación de que el id exista en base de datos
            Optional<Admin> temp = adminRepository.getAdmin(admin.getIdAdmin());
            if (!temp.isEmpty()) {
                if (admin.getAdminNombres() != null)
                    temp.get().setAdminNombres(admin.getAdminNombres());
                if (admin.getAdminApellidos() != null)
                    temp.get().setAdminApellidos(admin.getAdminApellidos());
                if (admin.getAdminEmail() != null)
                    temp.get().setAdminEmail(admin.getAdminEmail());
                if (admin.getAdminPassword() != null)
                    temp.get().setAdminPassword(admin.getAdminPassword());
                return adminRepository.save(temp.get());
            } else
                return admin;
        } else
            return admin;
    }

    // Eliminar
    public boolean deleteAdmin(int IdAdmin) {
        Boolean success = getAdmin(IdAdmin).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return success;
    }

}
