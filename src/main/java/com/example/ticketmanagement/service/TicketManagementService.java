package com.example.ticketmanagement.service;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ticketmanagement.model.TicketManager;
import com.example.ticketmanagement.repository.TicketManagementRepository;

/**
 * @author pratikprajapati
 *
 *
 *         This is the service layer for Ticket Management Application
 */
@Service
public class TicketManagementService {

  @Autowired
  private TicketManagementRepository ticketManagementRepository;

  @Autowired
  private NotificationService emailService;

  public TicketManager findByTicketId(Long ticketId) {
    return ticketManagementRepository.findByTicketId(ticketId);
  }

  public List<TicketManager> findAll() {
    return ticketManagementRepository.findAll();
  }

  public TicketManager saveOrUpdate(TicketManager ticketManager) throws MessagingException {
    ticketManager.setTicketId(ticketId.get());
    TicketManager returnObject = ticketManagementRepository.save(ticketManager);
    // TODO: To send the email uncomment below code and provide valid credentials
    // emailService.sendNotification(returnObject);
    return returnObject;
  }

  Supplier<Long> ticketId = () -> {
    Random r = new Random(System.currentTimeMillis());
    return (long) ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
  };
}
