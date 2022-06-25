package com.example.ticketmanagement.service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Component;
import com.example.ticketmanagement.model.TicketManager;

/**
 * @author pratikprajapati
 *
 *         This is the Email service class which is used to send notification via email
 */
@Component
public class EmailService implements NotificationService {

  @Override
  public void sendNotification(TicketManager ticketManager) throws MessagingException {

    Properties prop = new Properties();
    prop.put("mail.smtp.auth", true);
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", "smtp.mailtrap.io");
    prop.put("mail.smtp.port", "25");
    prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

    Session session = Session.getInstance(prop, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("username", "password");
      }
    });

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("from@gmail.com"));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
    message.setSubject(ticketManager.getPersonName() + " : " + ticketManager.getProblemDetail());

    String msg = "Your complaint is successfully registered. Your ticket id is: "
        + ticketManager.getTicketId() + " Our support person will get in touch with you soon.";

    MimeBodyPart mimeBodyPart = new MimeBodyPart();
    mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(mimeBodyPart);
    message.setContent(multipart);
    Transport.send(message);
  }
}
