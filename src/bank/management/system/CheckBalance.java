package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class CheckBalance extends JFrame implements ActionListener {
    String cardNumber;
    JButton backButton;
    int balance;
    CheckBalance(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        balance = 0;
        try {
            Conn c = new Conn();
            String queryOne = "SELECT * FROM bank WHERE card_number = '" + cardNumber + "';";
            ResultSet rs = c.s.executeQuery(queryOne);
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        JLabel showBalance = new JLabel("Rs. " + balance);
        showBalance.setFont(new Font("Arial", Font.BOLD, 18));
        showBalance.setBounds(385, 220, 200, 50);
        showBalance.setForeground(Color.WHITE);
        atmImage.add(showBalance);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(500, 350, 120, 30);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        atmImage.add(backButton);

        JPanel blackScreen = new JPanel();
        blackScreen.setBackground(Color.BLACK);
        blackScreen.setBounds(205, 165, 460, 310);
        atmImage.add(blackScreen);

        JLabel screenTitle = new JLabel("Your current balance is:");
        screenTitle.setFont(new Font("Arial", Font.BOLD, 15));
        screenTitle.setForeground(Color.WHITE);
        blackScreen.add(screenTitle);

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            setVisible(false);
            new Transaction(cardNumber);
        }
    }
    public static void main(String[] args) {
        new CheckBalance("");
    }
}

