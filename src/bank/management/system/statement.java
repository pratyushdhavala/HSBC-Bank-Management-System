package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class statement extends JFrame implements ActionListener {
    String cardNumber;

    JButton backButton;
    statement(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        JLabel title = new JLabel("Bank Statement");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(360, 50, 180, 50);
        add(title);

        JLabel nameTitle = new JLabel("Name: ");
        nameTitle.setFont(new Font("Arial", Font.BOLD, 18));
        nameTitle.setBounds(50, 100, 60, 50);
        add(nameTitle);

        JLabel name = new JLabel();
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(120, 100, 500, 50);
        add(name);

        JLabel cardTitle = new JLabel("Card No.");
        cardTitle.setFont(new Font("Arial", Font.BOLD, 18));
        cardTitle.setBounds(50, 150, 90, 30);
        add(cardTitle);

        JLabel card_no = new JLabel(cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
        card_no.setFont(new Font("Arial", Font.BOLD, 18));
        card_no.setBounds(140, 150, 200, 30);
        add(card_no);

        JLabel statement = new JLabel();
        statement.setFont(new Font("Arial", Font.PLAIN, 18));
        statement.setBounds(50, 230, 800, 500);
        add(statement);

        JLabel dateTitle = new JLabel("Date");
        dateTitle.setFont(new Font("Arial", Font.BOLD, 18));
        dateTitle.setBounds(50, 200, 80, 50);
        add(dateTitle);

        JLabel typeTitle = new JLabel("Type");
        typeTitle.setFont(new Font("Arial", Font.BOLD, 18));
        typeTitle.setBounds(340, 200, 80, 50);
        add(typeTitle);

        JLabel amountTitle = new JLabel("Amount");
        amountTitle.setFont(new Font("Arial", Font.BOLD, 18));
        amountTitle.setBounds(455, 200, 100, 50);
        add(amountTitle);

        JLabel balanceTitle = new JLabel("Balance");
        balanceTitle.setFont(new Font("Arial", Font.BOLD, 18));
        balanceTitle.setBounds(590, 200, 100, 50);
        add(balanceTitle);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(590, 700, 90, 30);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBackground(customColor);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        try {
            Conn c = new Conn();
            String queryOne = "SELECT * FROM signupthree WHERE card_number = '" + cardNumber + "';";
            ResultSet rs = c.s.executeQuery(queryOne);
            String formno = null;
            if (rs.next()) {
                formno = rs.getString("form_number");
            }

            String queryTwo = "SELECT * FROM signup WHERE form_number = '" + formno + "';";

            rs = c.s.executeQuery(queryTwo);
            String getName = null;
            if (rs.next()) {
                getName = rs.getString("name");
            }

            name.setText(getName);

            String queryThree = "SELECT * FROM bank WHERE card_number = '" + cardNumber + "';";

            rs = c.s.executeQuery(queryThree);

            int count = 0;
            int balance = 0;
            while (rs.next() && count < 10) {
                count++;

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdraw")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

                statement.setText(statement.getText() + "<html>" + rs.getString("date") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + balance + "<br><br><html>");
            }

            getContentPane().setBackground(Color.WHITE);
            setSize(900, 900);
            setLocation(350, 200);
            setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
        new Transaction(cardNumber);
    }
    public static void main(String[] args) {
        new statement("4059254302617143");
    }
}
