package com.green.sale.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
    public static boolean send(String to, String subject, String htmlMessage) {
        try {
            String username = ApplicationConfig.getConfig("mail.username");
            String password = ApplicationConfig.getConfig("mail.password");

            Properties prop = new Properties();
            prop.put("mail.smtp.host", ApplicationConfig.getConfig("mail.smtp.host"));
            prop.put("mail.smtp.port", ApplicationConfig.getConfig("mail.smtp.port"));
            prop.put("mail.smtp.auth", ApplicationConfig.getConfig("mail.smtp.auth"));
            prop.put("mail.smtp.starttls.enable", ApplicationConfig.getConfig("mail.smtp.starttls.enable")); // TLS

            Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ApplicationConfig.getConfig("mail.from")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setContent(htmlMessage, "text/html");

            Transport.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
