package me.khosraw;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();

        Credentials CREDENTIALS = Handlers.credentialHandler();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String finalEmail = CREDENTIALS.email;
        String finalPassword = CREDENTIALS.password;
        String finalTo = CREDENTIALS.to;
        String finalSubject = CREDENTIALS.subject;
        String finalContent = CREDENTIALS.content;

        // authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalEmail, finalPassword);
            }
        });

        while (true) {
            Message message = Handlers.messageHandler(session, finalEmail, finalTo, finalSubject, finalContent);

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
                    JOptionPane.showMessageDialog(null, "Hm, looks like something went wrong! Please report this to the developer.");
            }
        }
    }
}
