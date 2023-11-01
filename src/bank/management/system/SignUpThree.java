package bank.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;

public class SignUpThree extends JFrame implements ActionListener{
    Random random = new Random();
    JButton submit, cancel;
    JCheckBox agreement, eStatement, chequeBook, emailSMS, mobileBanking, internetBanking, atmCard;
    JRadioButton savingsAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;

        setLayout(null);

        Color customColor = new Color(238, 53, 36);

        JLabel formNumber = new JLabel("Application No. " + formno);
        formNumber.setFont(new Font("Arial", Font.BOLD, 24));
        formNumber.setBounds(305, 50, 240, 50);
        add(formNumber);

        JLabel pageNoThree = new JLabel("Page 3 of 3");
        pageNoThree.setFont(new Font("Arial", Font.BOLD, 16));
        pageNoThree.setBounds(720, 10, 100, 50);
        add(pageNoThree);

        JLabel accountDetails = new JLabel("Account Details");
        accountDetails.setFont(new Font("Arial", Font.BOLD, 20));
        accountDetails.setBounds(80, 100, 180, 50);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Arial", Font.BOLD, 18));
        accountType.setBounds(80, 150, 150, 50);
        add(accountType);

        savingsAccount = new JRadioButton("Saving Account");
        savingsAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        savingsAccount.setBounds(125, 200, 250, 50);
        add(savingsAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        fixedDepositAccount.setBounds(425, 200, 250, 50);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        currentAccount.setBounds(125, 250, 250, 50);
        add(currentAccount);

        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        recurringDepositAccount.setBounds(425, 250, 250, 50);
        add(recurringDepositAccount);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savingsAccount);
        accountGroup.add(currentAccount);
        accountGroup.add(fixedDepositAccount);
        accountGroup.add(recurringDepositAccount);

        JLabel cardNumber = new JLabel("Card Number");
        cardNumber.setFont(new Font("Arial", Font.BOLD, 18));
        cardNumber.setBounds(80, 300, 200, 50);
        add(cardNumber);

        JLabel cardNumberX = new JLabel("XXXX - XXXX - XXXX - XXXX");
        cardNumberX.setFont(new Font("Arial", Font.BOLD, 18));
        cardNumberX.setBounds(300, 300, 300, 50);
        add(cardNumberX);

        JLabel cardPIN = new JLabel("PIN");
        cardPIN.setFont(new Font("Arial", Font.BOLD, 18));
        cardPIN.setBounds(80, 350, 100, 50);
        add(cardPIN);

        JLabel cardPINX = new JLabel("X X X X");
        cardPINX.setFont(new Font("Arial", Font.BOLD, 18));
        cardPINX.setBounds(300, 350, 100, 50);
        add(cardPINX);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Arial", Font.BOLD, 18));
        services.setBounds(80, 400, 200, 50);
        add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Arial", Font.PLAIN, 18));
        atmCard.setBounds(125, 450, 250, 50);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Arial", Font.PLAIN, 18));
        internetBanking.setBounds(425, 450, 250, 50);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Arial", Font.PLAIN, 18));
        mobileBanking.setBounds(125, 500, 250, 50);
        add(mobileBanking);

        emailSMS = new JCheckBox("Email & SMS Alerts");
        emailSMS.setFont(new Font("Arial", Font.PLAIN, 18));
        emailSMS.setBounds(425, 500, 250, 50);
        add(emailSMS);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Arial", Font.PLAIN, 18));
        chequeBook.setBounds(125, 550, 250, 50);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Arial", Font.PLAIN, 18));
        eStatement.setBounds(425, 550, 250, 50);
        add(eStatement);

        agreement = new JCheckBox("I hereby agree that the above details are correct to the best of my knowledge.");
        agreement.setFont(new Font("Arial", Font.PLAIN, 18));
        agreement.setBounds(125, 600, 700, 50);
        add(agreement);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 18));
        submit.setBounds(250, 670, 125, 40);
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setBackground(customColor);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.setBounds(450, 670, 125, 40);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setBackground(customColor);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(850 ,800);
        setLocation(350, 10);
        setTitle("Sign Up Page 3");


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (savingsAccount.isSelected()) {
                accountType = "Savings Account";
            } else if (currentAccount.isSelected()) {
                accountType = "Current Account";
            } else if (fixedDepositAccount.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (recurringDepositAccount.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            String cardNumber = "" + (Math.abs((random.nextLong() % 900000000L)) + 4059254000000000L);
            String pinNumber  = "" + Math.abs(random.nextInt() % 10000);
            ArrayList<String> facility = new ArrayList<>();
            if (atmCard.isSelected()) {
                facility.add("ATM Card");
            }
            if (internetBanking.isSelected()) {
                facility.add("Internet Banking");
            }
            if (mobileBanking.isSelected()) {
                facility.add("Mobile Banking");
            }
            if (emailSMS.isSelected()) {
                facility.add("Email & SMS Alerts");
            }
            if (chequeBook.isSelected()) {
                facility.add("Cheque Book");
            }
            if (eStatement.isSelected()) {
                facility.add("E-Statement");
            }
            boolean policy = false;
            if (agreement.isSelected()) {
                policy = true;
            }
            String facilities = "";
            if (!facility.isEmpty()) {
                for (int i = 0; i < facility.size() - 1; i++) {
                    facilities = facilities + facility.get(i) + ", ";
                }
                facilities = facilities + facility.get(facility.size() - 1);
            }
            try {
                if (accountType.equals("") || policy == false) {
                    JOptionPane.showMessageDialog(null, "Please enter the required fields");
                } else {
                    Conn c = new Conn();
                    String queryOne = "insert into signupthree values ('" + formno + "', '" + cardNumber + "', '" +
                                    pinNumber + "', '" + accountType + "', '" + facilities + "');";
                    c.s.executeUpdate(queryOne);
                    JOptionPane.showMessageDialog(null, "Card Number: " +
                                                    cardNumber + "\n PIN: " + pinNumber +
                                                    "\n Please note down the details as you can only view it once");
                    String queryTwo = "insert into login values ('" + cardNumber + "', '" + pinNumber + "');";
                    c.s.executeUpdate(queryTwo);

                    JOptionPane.showMessageDialog(null, "New customers are required to " +
                            "deposit a minimum of Rs. 10000 /- . You are being redirected to the ATM page.");

                    setVisible(false);
                    new Deposit(cardNumber);
                }
            } catch(Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}
