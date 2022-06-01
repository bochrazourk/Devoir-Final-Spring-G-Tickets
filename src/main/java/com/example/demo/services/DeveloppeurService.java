package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Developpeur;
import com.example.demo.models.Ticket;

public interface DeveloppeurService {
    void ajouter(Developpeur developpeur);
    void modifier(Developpeur developpeur);
    void delete(long id);
    List<Developpeur> getAll();
    Developpeur get(long id);
    List<Ticket> getDeveloppeurTickets(long id);
    void statutTicket(long id, String etat);
}