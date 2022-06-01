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

import com.example.demo.models.Developpeur;
import com.example.demo.models.Ticket;
import com.example.demo.services.DeveloppeurServiceImpl;

@RestController
@RequestMapping("/devs")
public class DeveloppeurControllerRest {
    @Autowired
    DeveloppeurServiceImpl developpeurService;

    @PostMapping
    public void createDeveloppeur(@RequestBody Developpeur developpeur) {
        developpeurService.ajouter(developpeur);
    }

    @PutMapping
    public void updateDeveloppeur(@RequestBody Developpeur developpeur) {
        developpeurService.modifier(developpeur);
    }

    @GetMapping
    public List<Developpeur> getAll() {
        return developpeurService.getAll();
    }

    @GetMapping("/tickets/{id}")
    public List<Ticket> getDeveloppeurTickets(long id) {
        return developpeurService.getDeveloppeurTickets(id);
    }

    @GetMapping("/{id}")
    public Developpeur get(@PathVariable long id) {
        return developpeurService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        developpeurService.delete(id);
    }

    @PutMapping("/tickets/{id}/{etat}")
    public void etatTicket(@PathVariable long id, @PathVariable String etat) {
        developpeurService.statutTicket(id, etat);
    }
}

