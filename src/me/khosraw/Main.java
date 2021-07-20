package me.khosraw;

import javax.mail.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws MessagingException {
        JFrame frame = new JFrame();
        frame.setTitle("JMail");
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("logo.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(32, 38, 44));

        // Sender.sendMail();
    }
}
