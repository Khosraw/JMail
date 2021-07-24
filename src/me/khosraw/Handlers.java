package me.khosraw;

import org.jetbrains.annotations.Contract;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Handlers extends Sender {

    protected static Credentials credentialHandler() {
        String EMAIL = null;
        String PASSWORD = null;

        UIManager.put("OptionPane.background", new ColorUIResource(32, 38, 44));
        UIManager.put("OptionPane.foreground", Color.WHITE);
        UIManager.put("Panel.background", new ColorUIResource(32, 38, 44));
        UIManager.put("TextField.background", new java.awt.Color(62, 68, 74));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("PasswordField.foreground", Color.WHITE);
        UIManager.put("Button.background", new java.awt.Color(62, 68, 74));
        UIManager.put("Button.foreground", Color.white);
        JPanel panel = new JPanel();

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setForeground(Color.WHITE);
        JTextField email = new JTextField(32);
        email.setBackground(new Color(32, 38, 44));
        JLabel labelPass = new JLabel("Password:");
        JPasswordField pass = new JPasswordField(16);
        pass.setBackground(new Color(32, 38, 44));
        panel.add(labelEmail);
        panel.add(email);
        panel.add(labelPass);
        panel.add(pass);
        String[] options1 = new String[]{"Login", "Cancel"};
        int option1 = JOptionPane.showOptionDialog(null, panel, "Credentials",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, options1[0]);
        if (option1 == 0) {
            EMAIL = email.getText();
            char[] passwordChar = pass.getPassword();
            PASSWORD = new String(passwordChar);
        } else {
            System.exit(2);
        }

        return new Credentials(EMAIL, PASSWORD);
    }

    @Contract(" -> new")
    protected static Credentials messageInfoHandler () {
        UIManager.put("OptionPane.background",new ColorUIResource(32, 38, 44));
        UIManager.put("OptionPane.foreground",Color.WHITE);
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextArea.background", new java.awt.Color(62, 68, 74));
        UIManager.put("TextArea.foreground", Color.WHITE);
        UIManager.put("Panel.background",new ColorUIResource(32, 38, 44));
        UIManager.put("Button.background",new java.awt.Color(62, 68, 74));
        UIManager.put("Button.foreground", Color.WHITE);

        String TO = null;
        String SUBJECT = null;
        String CONTENT = null;

        JPanel panel = new JPanel();

        JTextField to = new JTextField(20);
        JTextField subject = new JTextField(10);
        JTextArea message = new JTextArea(5, 20);

        JLabel labelTo = new JLabel("To:");
        JLabel labelSubject = new JLabel("Subject:");
        JLabel labelMessage = new JLabel("Message:");

        panel.add(labelTo);
        panel.add(to);
        panel.add(labelSubject);
        panel.add(subject);
        panel.add(labelMessage);
        panel.add(message);

        String[] options = {"Send", "Cancel"};

        int mail = JOptionPane.showOptionDialog(null, panel, "Main Info", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (mail == 0) {
            TO = to.getText();
            SUBJECT = subject.getText();
            CONTENT = message.getText();
        } else {
            System.exit(2);
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
