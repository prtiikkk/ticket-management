package com.example.ticketmanagement.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author pratikprajapati
 * 
 *         This is the Model class for Ticket Manager Application
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TicketManager {

  @GeneratedValue
  @Id
  @Column
  private Long id;
  @Column
  private String personName;
  @Column
  private String problemDetail;
  @Column
  private Long ticketId;
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date ticketDate;

  public Date getTicketDate() {
    return ticketDate;
  }

  public void setTicketDate(Date ticketDate) {
    this.ticketDate = ticketDate;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName;
  }

  public String getProblemDetail() {
    return problemDetail;
  }

  public void setProblemDetail(String problemDetail) {
    this.problemDetail = problemDetail;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }
}
