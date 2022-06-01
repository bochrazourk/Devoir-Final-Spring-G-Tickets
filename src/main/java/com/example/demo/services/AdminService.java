package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Admin;
import com.example.demo.models.Ticket;

public interface AdminService {
    void ajouter(Admin admin);
    void modifier(Admin admin);
    void delete(long id);
    List<Admin> getAll();
    Admin get(long id);
    List<Ticket> getTicketsNonAttribue();
    void attribuerTicket(long idDev, long idT);
}
