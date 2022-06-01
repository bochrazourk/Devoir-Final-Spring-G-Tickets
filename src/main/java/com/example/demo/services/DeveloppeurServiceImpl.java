package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Developpeur;
import com.example.demo.models.Ticket;
import com.example.demo.repository.DeveloppeurRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.DeveloppeurService;

@Service
public class DeveloppeurServiceImpl implements DeveloppeurService{
    @Autowired
    DeveloppeurRepository developpeurRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void ajouter(Developpeur developpeur) {
        developpeurRepository.save(developpeur);
    }

    @Override
    public void modifier(Developpeur developpeur) {
        Developpeur d = developpeurRepository.findById(developpeur.getId()).get();
        if(d != null) {
            d.setNom(developpeur.getNom());
            d.setPrenom(developpeur.getPrenom());
            developpeurRepository.save(d);
        }
    }

    @Override
    public void delete(long id) {
        developpeurRepository.deleteById(id);
    }

    @Override
    public List<Developpeur> getAll() {
        return developpeurRepository.findAll();
    }

    @Override
    public Developpeur get(long id) {
        return developpeurRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getDeveloppeurTickets(long id) {
        return ticketRepository.getDeveloppeurTickets(id);
    }

    @Override
    public void statutTicket(long id, String etat) {
        ticketRepository.statutTicket(id, etat);
    }
}
