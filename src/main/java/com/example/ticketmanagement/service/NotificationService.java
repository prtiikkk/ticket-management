package com.example.ticketmanagement.service;

import javax.mail.MessagingException;
import org.springframework.stereotype.Component;
import com.example.ticketmanagement.model.TicketManager;

/**
 * @author pratikprajapati
 *
 *         This is the interface for sending notification
 */
@Component
public interface NotificationService {
  public void sendNotification(TicketManager ticketManager) throws MessagingException;
}
