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

import com.example.demo.models.Client;
import com.example.demo.models.Ticket;
import com.example.demo.services.ClientServiceImpl;

@RestController
@RequestMapping("/clients")
public class ClientControllerRest {
    @Autowired
    ClientServiceImpl clientService;

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientService.ajouter(client);
    }

    @PostMapping("/tickets")
    public void createTicket(@RequestBody Ticket ticket) {
        clientService.creerTicket(ticket);
    }

    @PutMapping
    public void updateClient(@RequestBody Client client) {
        clientService.modifier(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/tickets/{id}")
    public List<Ticket> getTickets(long id) {
        return clientService.getTickets(id);
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable long id) {
        return clientService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.delete(id);
    }
}
