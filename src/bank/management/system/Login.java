package bank.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    String cardNumber;
    JButton login, clear, signup;
    JTextField cardNoText;
    JPasswordField enterPin;
    Login() {

        //Title on the window
        setTitle("ATM");

        setLayout(null);

        //Custom color matching HSBC bank logo
        Color customColor = new Color(238, 53, 36);

        //HSBC bank logo, have to see the video again to understand this part
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hsbc_logo.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, -18,150,150);
        add(label);

        //HSBC Bank text
        JLabel text = new JLabel("HSBC Bank");
        text.setBounds(150, 40, 500, 40);
        text.setFont(new Font("Arial", Font.BOLD, 38));
        add(text);

        //Card No. text
        JLabel cardNo = new JLabel("Card No.");
        cardNo.setBounds(180, 120, 100, 40);
        cardNo.setFont(new Font("Arial", Font.BOLD, 20));
        add(cardNo);

        //card field one, divided into four parts
        cardNoText = new JTextField();
        cardNoText.setBounds(300, 120, 200, 40);
        cardNoText.setFont( new Font("Arial", Font.BOLD, 18));
        cardNoText.setBorder(new LineBorder(Color.BLACK, 2));
        add(cardNoText);

        //pin text
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(180, 170, 100, 40 );
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        add(pin);

        //pin field
        enterPin = new JPasswordField();
        enterPin.setBounds(300, 170, 200, 40);
        enterPin.setBorder(new LineBorder(Color.BLACK, 2));
        enterPin.setFont(new Font("Arial", Font.BOLD, 18));
        add(enterPin);

        //login button
        login = new JButton("Sign In");
        login.setBackground(customColor);
        login.setForeground(Color.WHITE);
        login.setBounds(250, 250, 125, 40);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.setFont(new Font("Arial", Font.BOLD, 18));
        login.addActionListener(this);
        add(login);

        //clear button
        clear = new JButton("Clear");
        clear.setBackground(customColor);
        clear.setForeground(Color.WHITE);
        clear.setBounds(425, 250, 125, 40);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.addActionListener(this);
        add(clear);

        //signup button
        signup = new JButton("Sign Up");
        signup.setBackground(customColor);
        signup.setForeground(Color.WHITE);
        signup.setBounds(250, 325, 300, 40);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.setFont(new Font("Arial", Font.BOLD, 18));
        signup.addActionListener(this);
        add(signup);

        //background color
        getContentPane().setBackground(Color.WHITE);

        //window frame size
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardNoText.setText("");
            enterPin.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        } else if (ae.getSource() == login) {
            String cardNumber = cardNoText.getText();
            String pin = String.valueOf(enterPin.getPassword());

            String query = "select * from login where card_number = '" + cardNumber + "' " +
                            "and pin_number = '" + pin + "';";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(cardNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN." +
                                                    "Please try again.");
                }

            } catch(Exception e) {
                System.out.println(e);
            }


        }
    }

    public static void main(String[] args) {

        new Login();
    }
}
