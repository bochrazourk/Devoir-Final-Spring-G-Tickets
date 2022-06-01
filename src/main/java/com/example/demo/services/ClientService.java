package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Client;
import com.example.demo.models.Ticket;

public interface ClientService {
    void ajouter(Client client);
    void modifier(Client client);
    void delete(long id);
    List<Client> getAll();
    Client get(long id);
    List<Ticket> getTickets(long id);
    void creerTicket(Ticket ticket);
}