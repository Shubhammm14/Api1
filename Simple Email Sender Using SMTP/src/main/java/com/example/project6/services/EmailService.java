package com.example.project6.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to) {
        String from = "aresspanda@gmail.com";
        boolean flag = false;
        // Variable for Gmail
        String host = "smtp.gmail.com";

        // Get the system properties
        Properties properties = System.getProperties();

        // Setting important information to the properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");


        // Step 1: Get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("aresspanda@gmail.com", "fmwgxvucopntmhqg");
            }
        });
        Security.setProperty("crypto.policy", "unlimited");

        // Enable debugging to see what's happening during the sending process
        session.setDebug(true);

        // Step 2: Compose the email
        try {
            MimeMessage mimeMessage = new MimeMessage(session);

            // Set the sender's email address
            mimeMessage.setFrom(new InternetAddress(from));

            // Set the recipient's email address
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set the email subject
            mimeMessage.setSubject(subject);

            // Set the email content
            mimeMessage.setText(message);

            // Step 3: Send the email
            Transport.send(mimeMessage);

            flag = true;
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
        return flag;
    }
}
