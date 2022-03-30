/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bakcsányi Dominik
 */
public class JavaMail {
      public void sendMail(String recepient) throws Exception{
      System.out.println("Preparing");
        Properties properties = new Properties();
        
        properties.put("mail.sntp.auth", "true");
        properties.put("mail.sntp.starttls.enable", "true");
        properties.put("mail.sntp.host", "smtp.gmail.com");
        properties.put("mail.sntp.port", "587");
        
        String mailN = "ait.arthab1022@gmail.com";
        String p = "Caesium137";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            
            protected PasswordAuthentication getPaswordAuthentication() {
                return new PasswordAuthentication(mailN, p);
            }
        });
        
        Message message = prepareMessage(session, mailN, recepient);
        Transport.send(message);
        
        System.out.println("Message sent succesfully");
    }

    private Message prepareMessage(Session session, String mailN, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailN));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Test");
            message.setText("test works");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
