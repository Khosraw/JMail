package me.khosraw;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    MyJFrame () {
        this.setTitle("JMail");
        this.setSize(420, 420);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("logo.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(32, 38, 44));
    }
}
