package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class fastCash extends JFrame implements ActionListener {

    String cardNumber;
    JButton backButton, oneHundred, fiveHundred, tenThousand, fiveThousand, oneThousand, twoThousand;

    fastCash(String cardNumber) {

        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        oneHundred = new JButton("Rs. 100");
        oneHundred.setFont(new Font("Arial", Font.BOLD, 15));
        oneHundred.setBounds(225, 250, 165, 30);
        oneHundred.setOpaque(true);
        oneHundred.setBorderPainted(false);
        oneHundred.setBackground(customColor);
        oneHundred.setForeground(Color.WHITE);
        oneHundred.addActionListener(this);
        atmImage.add(oneHundred);

        fiveHundred = new JButton("Rs. 500");
        fiveHundred.setFont(new Font("Arial", Font.BOLD, 15));
        fiveHundred.setBounds(470, 250, 165, 30);
        fiveHundred.setOpaque(true);
        fiveHundred.setBorderPainted(false);
        fiveHundred.setBackground(customColor);
        fiveHundred.setForeground(Color.WHITE);
        fiveHundred.addActionListener(this);
        atmImage.add(fiveHundred);

        oneThousand = new JButton("Rs. 1000");
        oneThousand.setFont(new Font("Arial", Font.BOLD, 15));
        oneThousand.setBounds(225, 300, 165, 30);
        oneThousand.setOpaque(true);
        oneThousand.setBorderPainted(false);
        oneThousand.setBackground(customColor);
        oneThousand.setForeground(Color.WHITE);
        oneThousand.addActionListener(this);
        atmImage.add(oneThousand);

        twoThousand = new JButton("Rs. 2000");
        twoThousand.setFont(new Font("Arial", Font.BOLD, 15));
        twoThousand.setBounds(470, 300, 165, 30);
        twoThousand.setOpaque(true);
        twoThousand.setBorderPainted(false);
        twoThousand.setBackground(customColor);
        twoThousand.setForeground(Color.WHITE);
        twoThousand.addActionListener(this);
        atmImage.add(twoThousand);

        fiveThousand = new JButton("Rs. 5000");
        fiveThousand.setFont(new Font("Arial", Font.BOLD, 15));
        fiveThousand.setBounds(225, 350, 165, 30);
        fiveThousand.setOpaque(true);
        fiveThousand.setBorderPainted(false);
        fiveThousand.setBackground(customColor);
        fiveThousand.setForeground(Color.WHITE);
        fiveThousand.addActionListener(this);
        atmImage.add(fiveThousand);

        tenThousand = new JButton("Rs. 10000");
        tenThousand.setFont(new Font("Arial", Font.BOLD, 15));
        tenThousand.setBounds(470, 350, 165, 30);
        tenThousand.setOpaque(true);
        tenThousand.setBorderPainted(false);
        tenThousand.setBackground(customColor);
        tenThousand.setForeground(Color.WHITE);
        tenThousand.addActionListener(this);
        atmImage.add(tenThousand);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBounds(470, 400, 165, 30);
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

        JLabel screenTitle = new JLabel("Please select the amount you want to withdraw");
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
        } else if (ae.getSource() != backButton){

            try {
                Conn c = new Conn();
                Date date = new Date();

                String queryOne = "select * from bank where card_number = '" + cardNumber + "';";
                ResultSet rs = c.s.executeQuery(queryOne);
                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdraw")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                String amount = ((JButton) ae.getSource()).getText().substring(4);
                System.out.println(balance);

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance. " +
                            "\n Current balance is Rs. " + balance);
                    return;
                }

                String queryTwo = "insert into bank values ('" + cardNumber + "', '" + date +
                        "', 'Withdraw', '" + amount + "');";
                c.s.executeUpdate(queryTwo);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " successfully withdrew");
            } catch (Exception e) {
                System.out.println(e);

            }
        }
    }
    public static void main(String[] args) {

        new fastCash("");
    }

}