package me.khosraw;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Handlers {

    public static Credentials credentialHandler() {
        String email = JOptionPane.showInputDialog("Enter your email:");
        String password = null;
        String to = null;
        String subject = null;
        String content = null;

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(16);
        panel.add(label);
        panel.add(pass);
        String[] options1 = new String[]{"OK", "Cancel"};
        int option1 = JOptionPane.showOptionDialog(null, panel, "Password",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, options1[1]);
        if(option1 == 0) // pressing OK button
        {
            char[] passwordChar = pass.getPassword();
            password = new String(passwordChar);
        } else {
            JOptionPane.showMessageDialog(null, "Looks like you exited the program. If you think this is a mistake, please report it to the developer!");
            System.exit(2);
        }

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
            to = value1.getText();
            subject = value2.getText();
            content = value3.getText();
        }

        return new Credentials(email, password, to, subject, content);
    }

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
