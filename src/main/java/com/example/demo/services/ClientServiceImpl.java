package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.models.Ticket;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void ajouter(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void modifier(Client client) {
        Client c = clientRepository.findById(client.getId()).get();
        if(c != null) {
            c.setNom(client.getNom());
            c.setPrenom(client.getPrenom());
            clientRepository.save(c);
        }
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client get(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getTickets(long id) {
        return ticketRepository.getClientTickets(id);
    }

    @Override
    public void creerTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

}
