package com.example.ticketmanagement.controller;

import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.ticketmanagement.model.TicketManager;
import com.example.ticketmanagement.service.TicketManagementService;

/**
 * @author pratikprajapati
 * 
 *         This is the entry point for all the requests
 *
 */
@RestController
public class TicketManagementController {

  @Autowired
  private TicketManagementService ticketManagementService;

  @GetMapping("/findAll")
  public List<TicketManager> findAll() {
    return ticketManagementService.findAll();
  }

  @PostMapping("/addTicket")
  public ResponseEntity<TicketManager> addTicket(@RequestBody TicketManager ticketManager)
      throws MessagingException {
    return new ResponseEntity<TicketManager>(ticketManagementService.saveOrUpdate(ticketManager),
        HttpStatus.CREATED);
  }

  @GetMapping("/ticketId/{ticketId}")
  public ResponseEntity<TicketManager> findByticketId(@PathVariable Long ticketId) {
    return new ResponseEntity<TicketManager>(ticketManagementService.findByTicketId(ticketId),
        HttpStatus.OK);
  }
}
