package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    String cardNumber;
    JButton depositButton, backButton;
    JTextField enterAmount;
    Deposit(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        JLabel prompt = new JLabel("Enter the amount you want to deposit");
        prompt.setFont(new Font("Arial", Font.BOLD, 16));
        prompt.setBounds(290, 180, 300, 50);
        prompt.setForeground(Color.WHITE);
        atmImage.add(prompt);

        enterAmount = new JTextField();
        enterAmount.setFont(new Font("Arial", Font.BOLD, 24));
        enterAmount.setBounds(330, 250, 200, 50);
        atmImage.add(enterAmount);

        depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arial", Font.BOLD, 18));
        depositButton.setBounds(245, 350, 150, 30);
        depositButton.setOpaque(true);
        depositButton.setBorderPainted(false);
        depositButton.setBackground(customColor);
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this);
        atmImage.add(depositButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(470, 350, 150, 30);
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

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == depositButton) {

            String amount = enterAmount.getText();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }
            Date date = new Date();
            try {
                Conn c = new Conn();
                String query = "insert into bank values ('" + cardNumber + "', '" + date +
                                "', 'Deposit', '" + amount + "');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " successfully deposited");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transaction(cardNumber);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
