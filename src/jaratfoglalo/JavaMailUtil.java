/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import static jaratfoglalo.JaratFoglalo.newPass;
import static jaratfoglalo.JaratFoglalo.sendTo;

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
public class JavaMailUtil {
       
 
      public static void sendMail(String recepient) throws Exception{
          
     
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String mailN = "ait.arthab1022@gmail.com";
        String p = "Caesium137";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                "ait.arthab1022@gmail.com", "Caesium137");
        }
        });
        
        Message message = prepareMessage(session, mailN, recepient);
        Transport.send(message);
        
        
    }

    private static Message prepareMessage(Session session, String mailN, String recepient) {
       try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailN));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Athab Interstellar Transport (Password reset request)");
            message.setText("Dear " +sendTo+"!\nYou requested a new password for Arthab Interstellar Transport\nYour new password is: " +newPass);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
/*
    private Message prepareMessage(Session session, String mailN) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailN));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Test");
            message.setText("test works");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
    
}
