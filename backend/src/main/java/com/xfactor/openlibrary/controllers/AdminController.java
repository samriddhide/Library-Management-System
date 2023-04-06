package com.xfactor.openlibrary.controllers;

import com.xfactor.openlibrary.domain.Admin;
import com.xfactor.openlibrary.repository.AdminRepository;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
//import java.util.HashMap;

@RestController
@RequestMapping("admin")
public class AdminController {
    //ArrayList<Admin> ladmin = new ArrayList<>();
    private AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/saveadmin")
    public Admin saveAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return admin;
    }

    @GetMapping("/getAll")
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    // get admin by id
    @GetMapping("/getAdminById")
    public Admin findById(@PathVariable long id) {
        Optional<Admin> optionalofAdmin = adminRepository.findById(id);
        if (optionalofAdmin.isPresent()) {
            return optionalofAdmin.get();
        }
        return null;
    }

    // get admin by name
    @GetMapping("/getAdminByName/{name}")
    public List<Admin> findByName(@PathVariable String name) {
        List<Admin> optionalofAdmin = adminRepository.findByName(name);
        return optionalofAdmin;
    }

    // get admin by username
    @GetMapping("/getAdminByUsername/{username}")
    public List<Admin> findByUsername(@PathVariable String username) {
        List<Admin> optionalofAdmin = adminRepository.findByUsername(username);
        return optionalofAdmin;
    }

    // get admin by password
    @GetMapping("/getAdminByPassword/{password}")
    public List<Admin> findByPassword(@PathVariable String password) {
        List<Admin> optionalofAdmin = adminRepository.findByPassword(password);
        return optionalofAdmin;
    }

    // update admin
    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        if (admin.getId() != 0L) {
            Admin admin2 = adminRepository.save(admin);
            return admin2;
        }
        return null;
    }

    // delete admin
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }






}
