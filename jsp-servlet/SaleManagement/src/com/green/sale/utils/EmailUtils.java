package com.green.sale.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtils {
    public static boolean send(String to, String subject, String htmlMessage) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", ApplicationConfig.getConfig("mail.smtp.auth"));
            prop.put("mail.smtp.starttls.enable", ApplicationConfig.getConfig("mail.smtp.starttls.enable"));
            prop.put("mail.smtp.host", ApplicationConfig.getConfig("mail.smtp.host"));
            prop.put("mail.smtp.port", ApplicationConfig.getConfig("mail.smtp.port"));
            prop.put("mail.smtp.ssl.trust", ApplicationConfig.getConfig("mail.smtp.ssl.trust"));
    
            String sender = ApplicationConfig.getConfig("mail.from");
            String username = ApplicationConfig.getConfig("mail.username");
            String password = ApplicationConfig.getConfig("mail.password");
    
            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(htmlMessage, "text/html");
    
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
    
            message.setContent(multipart);

            Transport.send(message);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
