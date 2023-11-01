package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;
public class Withdraw extends JFrame implements ActionListener {
    String cardNumber;
    JButton withdrawButton, backButton;
    JTextField enterAmount;

    Withdraw(String cardNumber) {
        this.cardNumber = cardNumber;
        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        JLabel prompt = new JLabel("Enter the amount you want to withdraw");
        prompt.setFont(new Font("Arial", Font.BOLD, 16));
        prompt.setBounds(290, 180, 300, 50);
        prompt.setForeground(Color.WHITE);
        atmImage.add(prompt);

        enterAmount = new JTextField();
        enterAmount.setFont(new Font("Arial", Font.BOLD, 24));
        enterAmount.setBounds(330, 250, 200, 50);
        atmImage.add(enterAmount);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 18));
        withdrawButton.setBounds(245, 350, 150, 30);
        withdrawButton.setOpaque(true);
        withdrawButton.setBorderPainted(false);
        withdrawButton.setBackground(customColor);
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this);
        atmImage.add(withdrawButton);

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

        if (ae.getSource() == withdrawButton) {

            String amount = enterAmount.getText();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }
            Date date = new Date();
            try {
                Conn c = new Conn();

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
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transaction(cardNumber);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
