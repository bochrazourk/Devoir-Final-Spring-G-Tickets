package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Ticket;

public interface TicketService {
    void ajouter(Ticket ticket);
    void modifier(Ticket ticket);
    void delete(long id);
    List<Ticket> getAll();
    Ticket get(long id);
}
