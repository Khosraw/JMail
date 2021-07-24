package me.khosraw;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    public static void myJFrame (JFrame myJFrame) {
        ImageIcon image = new ImageIcon("logo.jpg");
        myJFrame.setIconImage(image.getImage());
        myJFrame.getContentPane().setBackground(new Color(32, 38, 44));
        myJFrame.setLayout(null);

        myJFrame.setTitle("JMail");
        myJFrame.setSize(780, 520);
        myJFrame.setResizable(false);
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(52, 58, 64));
        mainPanel.setBounds(150, 70, 630, 520);
        mainPanel.setLayout(null);
        myJFrame.add(mainPanel);

        JLabel titleJLabel = new JLabel();
        titleJLabel.setText("JMail");
        titleJLabel.setForeground(Color.WHITE);
        titleJLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        titleJLabel.setBounds(280, 20, 120, 70);
        mainPanel.add(titleJLabel);
        titleJLabel.revalidate();
        titleJLabel.repaint();

        JLabel myJLabel = new JLabel();
        myJLabel.setText("<html><br/><br/><br/>Welcome to JMail!<br/><br/>JMail is a simple email client developed using Java.<br/>Make sure to report any bugs to the official GitHub page.</html>");
        myJLabel.setForeground(Color.WHITE);
        myJLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));

        myJLabel.setVisible(true);
        mainPanel.add(myJLabel);
        myJLabel.revalidate();
        myJLabel.repaint();


    }
}
