package me.khosraw;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    public static void myJFrame (JFrame myJFrame) {
        ImageIcon image = new ImageIcon("logo.jpg");
        myJFrame.setIconImage(image.getImage());
        myJFrame.getContentPane().setBackground(new Color(32, 38, 44));

        myJFrame.setTitle("JMail");
        myJFrame.setSize(780, 520);
        myJFrame.setResizable(false);
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel myJLabel = new JLabel();
        myJLabel.setText("<html>Welcome to JMail!<br/><br/>JMail is a simple email client developed using Java.<br/>Make sure to report any bugs to the official GitHub page.</html>");
        myJLabel.setForeground(Color.WHITE);
        myJLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
        myJLabel.setHorizontalAlignment(JLabel.CENTER);
        myJLabel.setVerticalAlignment(JLabel.TOP);
        myJLabel.setVisible(true);
        myJFrame.add(myJLabel);


    }
}
