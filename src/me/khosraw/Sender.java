package me.khosraw;

import javax.mail.*;
import javax.swing.*;
import java.util.Properties;

public class Sender {
    public static void sendMail () throws MessagingException {
        Properties properties = new Properties();

        Credentials CREDENTIALS = Handlers.credentialHandler();
        Credentials MESSAGE = Handlers.messageInfoHandler();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String finalEmail;
        String finalPassword = CREDENTIALS.getPass();
        String finalTo;
        String finalSubject;
        String finalContent;

        // authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CREDENTIALS.getEmail(), finalPassword);
            }
        });

        while (true) {
            finalEmail = CREDENTIALS.getEmail();
            finalTo = MESSAGE.to;
            finalSubject = MESSAGE.subject;
            finalContent = MESSAGE.content;

            Message message = Handlers.messageHandler(session, finalEmail, finalTo, finalSubject, finalContent);

            assert message != null;
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email successfully sent!");

            String[] options2 = {"Yes", "No"};
            int option2 = JOptionPane.showOptionDialog(null, "Would you like to send more emails?", "Continue?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
            switch (option2) {
                case 0:
                    MESSAGE = Handlers.messageInfoHandler();
                    break;
                case 1:
                    System.exit(1);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Hm, looks like something went wrong! Please report this to the developer.");
            }
        }
    }
}
