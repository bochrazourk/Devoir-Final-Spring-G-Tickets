package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.models.Ticket;
import com.example.demo.services.AdminServiceImpl;

@RestController
@RequestMapping("/admins")
public class AdminControllerRest {
    @Autowired
    AdminServiceImpl adminService;

    @PostMapping
    public void createAdmin(@RequestBody Admin admin) {
        adminService.ajouter(admin);
    }

    @PutMapping
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.modifier(admin);
    }

    @GetMapping
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/tickets")
    public List<Ticket> getTicketsNonAttribue() {
        return adminService.getTicketsNonAttribue();
    }

    @PutMapping("/tickets/{idDev}/{idT}")
    public void attribuerTicket(@PathVariable long idDev, @PathVariable long idT) {
        adminService.attribuerTicket(idDev, idT);
    }

    @GetMapping("/{id}")
    public Admin get(@PathVariable long id) {
        return adminService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable long id) {
        adminService.delete(id);
    }
}
