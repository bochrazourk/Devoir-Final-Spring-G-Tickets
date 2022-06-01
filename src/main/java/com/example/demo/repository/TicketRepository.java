package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.developpeur.id is null")
    List<Ticket> getTicketsNonAttribue();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Ticket t set t.developpeur.id = ?1 WHERE t.id = ?2")
    void attribuerTicket(long idDev, long idT);

    @Query("SELECT t FROM Ticket t WHERE t.client.id = ?1")
    List<Ticket> getClientTickets(long id);

    @Query("SELECT t FROM Ticket t WHERE t.client.username = ?1")
    List<Ticket> getClientTicketsByUserName(String username);

    @Query("SELECT t FROM Ticket t WHERE t.developpeur.id = ?1")
    List<Ticket> getDeveloppeurTickets(long id);

    @Query("SELECT t FROM Ticket t WHERE t.developpeur.username = ?1")
    List<Ticket> getDeveloppeurTicketsByUserName(String username);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Ticket t set t.statut = ?2 WHERE t.id = ?1")
    void statutTicket(long id, String statut);
}
