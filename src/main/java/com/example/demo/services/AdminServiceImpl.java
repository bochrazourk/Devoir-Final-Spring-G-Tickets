package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.models.Ticket;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void ajouter(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void modifier(Admin admin) {
        Admin a = adminRepository.findById(admin.getId()).get();
        if(a != null) {
            a.setNom(admin.getNom());
            a.setPrenom(admin.getPrenom());
            adminRepository.save(a);
        }
    }

    @Override
    public void delete(long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin get(long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getTicketsNonAttribue() {
        return ticketRepository.getTicketsNonAttribue();
    }

    @Override
    public void attribuerTicket(long idDev, long idT) {
        ticketRepository.attribuerTicket(idDev, idT);
    }
}
