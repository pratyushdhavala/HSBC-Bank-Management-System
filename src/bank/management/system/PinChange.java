package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener {
    JButton submit, backButton;
    String cardNumber;

    JPasswordField enterPINText, confirmPINText;

    PinChange(String cardNumber) {
        this.cardNumber = cardNumber;

        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImage = new JLabel(i3);
        atmImage.setBounds(0, 0, 900, 900);
        add(atmImage);

        JLabel enterPIN = new JLabel("Enter new PIN:");
        enterPIN.setFont(new Font("Arial", Font.BOLD, 18));
        enterPIN.setBounds(220, 210, 150, 50);
        enterPIN.setForeground(Color.WHITE);
        atmImage.add(enterPIN);

        enterPINText = new JPasswordField();
        enterPINText.setFont(new Font("Arial", Font.PLAIN, 18));
        enterPINText.setBounds(400, 220, 60, 30);
        atmImage.add(enterPINText);

        JLabel confirmPIN = new JLabel("Confirm new PIN:");
        confirmPIN.setFont(new Font("Arial", Font.BOLD, 18));
        confirmPIN.setBounds(220, 260, 150, 50);
        confirmPIN.setForeground(Color.WHITE);
        atmImage.add(confirmPIN);

        confirmPINText = new JPasswordField();
        confirmPINText.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmPINText.setBounds(400, 270, 60, 30);
        atmImage.add(confirmPINText);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setBounds(250, 350, 120, 30);
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setBackground(customColor);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        atmImage.add(submit);

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

        JLabel screenTitle = new JLabel("PIN Change");
        screenTitle.setFont(new Font("Arial", Font.BOLD, 15));
        screenTitle.setForeground(Color.WHITE);
        blackScreen.add(screenTitle);

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 900);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String newPIN = String.valueOf(enterPINText.getPassword());
            String confirmPIN = String.valueOf(confirmPINText.getPassword());

            if (newPIN.length() != 4) {
                JOptionPane.showMessageDialog(null, "PIN number should be four digits only. Please try again.");
                enterPINText.setText("");
                confirmPINText.setText("");
            } else if (!newPIN.equals(confirmPIN)) {
                JOptionPane.showMessageDialog(null, "PIN numbers do not match. Please try again.");
                enterPINText.setText("");
                confirmPINText.setText("");
            } else {
                try {
                    Conn c = new Conn();
                    String queryOne = "UPDATE login SET pin_number = '" + newPIN + "' WHERE card_number = '" + cardNumber + "';";
                    c.s.executeUpdate(queryOne);

                    String queryTwo = "UPDATE signupthree SET pin_number = '" + newPIN + "' WHERE card_number = '" + cardNumber + "';";
                    c.s.executeUpdate(queryTwo);

                    JOptionPane.showMessageDialog(null, "PIN successfully changed. Please login with new PIN.");
                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Transaction(cardNumber);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
