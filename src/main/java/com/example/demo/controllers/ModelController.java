package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Developpeur;
import com.example.demo.models.Ticket;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.AdminService;
import com.example.demo.services.DeveloppeurService;

@Controller
public class ModelController {

    @Autowired
    AdminService adminService;
    @Autowired
    DeveloppeurService devService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;


    @GetMapping("/home")
    public String home(Model m) {
        return "tickets/home";
    }


    @GetMapping("/admin")
    public String Admin(Model model) {
        List<Developpeur> devs = devService.getAll();
        model.addAttribute("devs", devs);
        model.addAttribute("dev", new Developpeur());
        List<Ticket> tickets = adminService.getTicketsNonAttribue();
        model.addAttribute("tickets", tickets);
        model.addAttribute("ticket", new Ticket());
        return "tickets/admin";
    }

    @PostMapping("/admin/attrib")
    public String attribuerTicket(@RequestParam("dev") int idDev, @RequestParam("ticket")int idT) {
        adminService.attribuerTicket(idDev, idT);
        return "redirect:/admin";
    }

    @GetMapping("/client")
    public String Client(Model m) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Ticket> tickets= ticketRepository.getClientTicketsByUserName(username);
        m.addAttribute("tickets", tickets);
        m.addAttribute("ticket", new Ticket());
        return "tickets/client";
    }

    @PostMapping("/client/add")
    public String ajouterTicket(@Valid Ticket ticket) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        ticket.setStatut("En cours");
        ticket.setClient(clientRepository.getClientByUsername(username));
        ticketRepository.save(ticket);
        return "redirect:/client";
    }

    @GetMapping("/dev")
    public String Developpeur(Model m) {
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        List<Ticket> tickets= ticketRepository.getDeveloppeurTicketsByUserName(username);
        m.addAttribute("tickets", tickets);
        m.addAttribute("ticket", new Ticket());
        return "tickets/developpeur";
    }

    @PostMapping("/dev/maj")
    public String statutTicket(@RequestParam("statut") String statut, @RequestParam("ticket") int idT) {
        ticketRepository.statutTicket(idT, statut);
        return "redirect:/dev";
    }

}
