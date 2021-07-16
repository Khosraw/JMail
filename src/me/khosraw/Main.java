package me.khosraw;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        JTextField value1 = new JTextField();
        JTextField value2 = new JTextField();

        String email = null;
        String password = null;

        Object[] messagesCred = {
                "Email Address: ", value1,
                "Password: ", value2,
        };

        int login = JOptionPane.showConfirmDialog(null, messagesCred, "Enter all your credentials!", JOptionPane.OK_CANCEL_OPTION);
        if (login == JOptionPane.OK_OPTION) {
            email = value1.getText();
            password = value2.getText();
        }

        JTextField value3 = new JTextField();
        JTextField value4 = new JTextField();
        JTextField value5 = new JTextField();

        String to = null;
        String subject = null;
        String content = null;

        Object[] messagesMail = {
                "To: ", value3,
                "Subject: ", value4,
                "Message: ", value5,
        };

        int mail = JOptionPane.showConfirmDialog(null, messagesMail, "Enter the mail info!", JOptionPane.OK_CANCEL_OPTION);
        if (mail == JOptionPane.OK_OPTION) {
            to = value3.getText();
            subject = value4.getText();
            content = value5.getText();
        }

        String finalEmail = email;
        String finalPassword = password;
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalEmail, finalPassword);
            }
        });

        Message message = messageHandler(session, email, to, subject, content);

        assert message != null;
        Transport.send(message);
        JOptionPane.showMessageDialog(null, "Email successfully sent!");
    }

    private static Message messageHandler(Session session, String email, String to, String subject, String content) {
        try {
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
