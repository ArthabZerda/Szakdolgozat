/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import static jaratfoglalo.JaratFoglalo.newPass;
import static jaratfoglalo.JaratFoglalo.sendTo;
import static jaratfoglalo.SendEmail.changePassFor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Properties;
import java.util.StringTokenizer;
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

    public JavaMailUtil(String pass) {
        this.pass = pass;
    }
    public String pass;
    private static String emailPass;
    public static void getP() {/*
        ArrayList<JavaMailUtil> adatok = new ArrayList<>();
        String pass1;
        String line;
        JavaMailUtil r;
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Bakcsányi Dominik\\Documents\\pass.txt"));
            StringTokenizer st;

            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line, "\t");
                pass1 = st.nextToken();

                r = new JavaMailUtil(pass1);
                adatok.add(r);
            }
            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        for (JavaMailUtil r1 : adatok) {
            emailPass=r1.pass;
       }*/
    }

    public static void sendMail(String recepient) throws Exception {

        getP();
        
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String mailN = "ait.arthab1022@gmail.com";
        

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "ait.arthab1022@gmail.com", "_\\(9812-&&32L*");
            }
        });
        //
        Message message = prepareMessage(session, mailN, recepient);
        Transport.send(message);

    }

    private static Message prepareMessage(Session session, String mailN, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailN));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Athab Interstellar Transport (Password reset request)");
            message.setText("Dear " + changePassFor + "!\nYou requested a new password for Arthab Interstellar Transport\nYour new password is: " + newPass + "\n\tIf the new password didn't work, please send us an email to ait.arthab1022@gmail.com");
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
