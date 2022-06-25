package com.example.ticketmanagement.service;

import org.springframework.stereotype.Component;
import com.example.ticketmanagement.model.TicketManager;

/**
 * @author pratikprajapati
 *
 *         This is the Message service class which is used to send notification via text message
 */
@Component
public class MessageService implements NotificationService {

  @Override
  public void sendNotification(TicketManager ticketManager) {
    System.out.println("Sending text message..");
  }

}
