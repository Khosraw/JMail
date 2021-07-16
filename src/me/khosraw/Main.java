package me.khosraw;

import javax.mail.*;
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


        String email = null;
        String password = null;

        Object[] messagesCred = {
                "Email Address: ", value1,
        };
        int login = JOptionPane.showConfirmDialog(null, messagesCred, "Enter all your credentials!", JOptionPane.OK_CANCEL_OPTION);
        if (login == JOptionPane.OK_OPTION) {
            email = value1.getText();
        }

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(16);
        panel.add(label);
        panel.add(pass);
        String[] options1 = new String[]{"OK", "Cancel"};
        int option1 = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, options1[1]);
        if(option1 == 0) // pressing OK button
        {
            char[] passwordChar = pass.getPassword();
            password = new String(passwordChar);
        } else {
            JOptionPane.showMessageDialog(null, "Looks like you exited the program. If you think this is a mistake, please report it to the developer!");
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

        // authentication
        String finalEmail = email;
        String finalPassword = password;
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalEmail, finalPassword);
            }
        });

        while (true) {
            Message message = Handlers.messageHandler(session, email, to, subject, content);

            assert message != null;
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email successfully sent!");

            String[] options2 = {"Yes", "No"};
            int option2 = JOptionPane.showOptionDialog(null, "Would you like to send more emails?","Continue?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
            switch (option2) {
                case 0:
                    break;
                case 1:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Hm, looks like something went wrong! Please report this to the developer.");
            }
        }
    }
}
