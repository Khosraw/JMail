package me.khosraw;

import org.jetbrains.annotations.Contract;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class Handlers extends Sender {

    protected static Credentials credentialHandler() {
        String EMAIL = null;
        String PASSWORD = null;

        JPanel panel = new JPanel();
        JLabel labelEmail = new JLabel("Enter an email:");
        JTextField email = new JTextField(32);
        JLabel labelPass = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(16);
        panel.add(labelEmail);
        panel.add(email);
        panel.add(labelPass);
        panel.add(pass);
        String[] options1 = new String[]{"Login", "Cancel"};
        int option1 = JOptionPane.showOptionDialog(null, panel, "Credentials",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, options1[1]);
        if (option1 == 0) {
            EMAIL = email.getText();
            char[] passwordChar = pass.getPassword();
            PASSWORD = new String(passwordChar);
        } else {
            JOptionPane.showMessageDialog(null, "Looks like you exited the program. If you think this is a mistake, please report it to the developer!");
            System.exit(2);
        }

        return new Credentials(EMAIL, PASSWORD);
    }

    @Contract(" -> new")
    protected static Credentials messageInfoHandler () {
        String TO = null;
        String SUBJECT = null;
        String CONTENT = null;

        JTextField value1 = new JTextField();
        JTextField value2 = new JTextField();
        JTextField value3 = new JTextField();

        Object[] messagesMail = {
                "To: ", value1,
                "Subject: ", value2,
                "Message: ", value3,
        };

        int mail = JOptionPane.showConfirmDialog(null, messagesMail, "Enter the mail info!", JOptionPane.OK_CANCEL_OPTION);
        if (mail == JOptionPane.OK_OPTION) {
            TO = value1.getText();
            SUBJECT = value2.getText();
            CONTENT = value3.getText();
        }

        return new Credentials(TO, SUBJECT, CONTENT);
    }

    protected static Message messageHandler(Session session, String email, String to, String subject, String content) {
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
