package com.example.ticketmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ticketmanagement.model.TicketManager;

/**
 * @author pratikprajapati
 *
 *         This is the Repository for Ticke Management Application
 */
@Repository
public interface TicketManagementRepository extends JpaRepository<TicketManager, Long> {
  public TicketManager findByTicketId(Long ticketId);

}
