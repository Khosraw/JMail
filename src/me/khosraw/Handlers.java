package me.khosraw;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Handlers {
    public static Message messageHandler(Session session, String email, String to, String subject, String content) {
        try {
            // message properties
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);
            return message;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
