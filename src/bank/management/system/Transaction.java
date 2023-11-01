package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Transaction extends JFrame implements ActionListener {

    String cardNumber;
    JButton exit, deposit, withdraw, balance, pinChange, fastCash, statement;
    Transaction(String cardNumber) {

        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 15));
        deposit.setBounds(225, 250, 165, 30);
        deposit.setOpaque(true);
        deposit.setBorderPainted(false);
        deposit.setBackground(customColor);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        atmImage.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setFont(new Font("Arial", Font.BOLD, 15));
        withdraw.setBounds(470, 250, 165, 30);
        withdraw.setOpaque(true);
        withdraw.setBorderPainted(false);
        withdraw.setBackground(customColor);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        atmImage.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setFont(new Font("Arial", Font.BOLD, 15));
        fastCash.setBounds(225, 300, 165, 30);
        fastCash.setOpaque(true);
        fastCash.setBorderPainted(false);
        fastCash.setBackground(customColor);
        fastCash.setForeground(Color.WHITE);
        fastCash.addActionListener(this);
        atmImage.add(fastCash);

        statement = new JButton("Statement");
        statement.setFont(new Font("Arial", Font.BOLD, 15));
        statement.setBounds(470, 300, 165, 30);
        statement.setOpaque(true);
        statement.setBorderPainted(false);
        statement.setBackground(customColor);
        statement.setForeground(Color.WHITE);
        statement.addActionListener(this);
        atmImage.add(statement);

        pinChange = new JButton("PIN Change");
        pinChange.setFont(new Font("Arial", Font.BOLD, 15));
        pinChange.setBounds(225, 350, 165, 30);
        pinChange.setOpaque(true);
        pinChange.setBorderPainted(false);
        pinChange.setBackground(customColor);
        pinChange.setForeground(Color.WHITE);
        pinChange.addActionListener(this);
        atmImage.add(pinChange);

        balance = new JButton("Check Balance");
        balance.setFont(new Font("Arial", Font.BOLD, 15));
        balance.setBounds(470, 350, 165, 30);
        balance.setOpaque(true);
        balance.setBorderPainted(false);
        balance.setBackground(customColor);
        balance.setForeground(Color.WHITE);
        balance.addActionListener(this);
        atmImage.add(balance);

        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 15));
        exit.setBounds(470, 400, 165, 30);
        exit.setOpaque(true);
        exit.setBorderPainted(false);
        exit.setBackground(customColor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        atmImage.add(exit);

        JPanel blackScreen = new JPanel();
        blackScreen.setBackground(Color.BLACK);
        blackScreen.setBounds(205, 165, 460, 310);
        atmImage.add(blackScreen);

        JLabel screenTitle = new JLabel("Greetings from HSBC Bank, what would you like to do today?");
        screenTitle.setFont(new Font("Arial", Font.BOLD, 15));
        screenTitle.setForeground(Color.WHITE);
        blackScreen.add(screenTitle);

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(350, 200);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNumber);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(cardNumber);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(cardNumber);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(cardNumber);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new CheckBalance(cardNumber);
        } else if (ae.getSource() == statement) {
            setVisible(false);
            new statement(cardNumber);
        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
