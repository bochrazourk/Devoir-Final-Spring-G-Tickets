package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.TicketService;

public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void ajouter(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void modifier(Ticket ticket) {
        Ticket t = ticketRepository.findById(ticket.getId()).get();
        if(t != null) {
            t.setDescription(ticket.getDescription());
            t.setEnvironnement(ticket.getEnvironnement());
            t.setUrgence(ticket.getUrgence());
            t.setStatut(ticket.getStatut());
            t.setLogiciel(ticket.getLogiciel());
            t.setDeveloppeur(ticket.getDeveloppeur());
            ticketRepository.save(t);
        }
    }

    @Override
    public void delete(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket get(long id) {
        return ticketRepository.findById(id).get();
    }
}
