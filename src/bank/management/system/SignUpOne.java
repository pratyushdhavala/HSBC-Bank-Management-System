package bank.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTF, fNameTF, emailIDTF, addressTF, cityTF, stateTF, pinCodeTF;
    JButton next;
    JRadioButton maleGender, femaleGender, otherGender, marriedMaritalStatus, singleMaritalStatus;
    JDateChooser dobChooser;
    SignUpOne() {
        Color customColor = new Color(238, 53, 36);

        setLayout(null);
        Random rand = new Random();

        random = Math.abs(rand.nextLong() % 9000L) + 1000L;

        JLabel formNo = new JLabel("Application No." + random);
        formNo.setFont(new Font("Arial", Font.BOLD, 24));
        formNo.setBounds(305, 50, 240, 50);
        add(formNo);

        JLabel pageNoOne = new JLabel("Page 1 of 3");
        pageNoOne.setFont(new Font("Arial", Font.PLAIN, 16));
        pageNoOne.setBounds(720, 10, 100, 50);
        add(pageNoOne);

        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Arial", Font.BOLD, 20));
        personalDetails.setBounds(80, 100, 180, 50);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(80, 150, 100, 50);
        add(name);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Arial", Font.PLAIN, 18));
        nameTF.setBounds(250, 160, 500, 30);
        nameTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(nameTF);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Arial", Font.BOLD, 18));
        fName.setBounds(80, 200, 150, 50);
        add(fName);

        fNameTF = new JTextField();
        fNameTF.setFont(new Font("Arial", Font.PLAIN, 18));
        fNameTF.setBounds(250, 210, 500, 30);
        fNameTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(fNameTF);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial", Font.BOLD, 18));
        dob.setBounds(80, 250, 150, 50);
        add(dob);

        dobChooser = new JDateChooser();
        dobChooser.setBounds(250, 260, 500, 30);
        add(dobChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 18));
        gender.setBounds(80, 300, 100, 50);
        add(gender);

        maleGender = new JRadioButton("Male");
        maleGender.setFont(new Font("Arial", Font.PLAIN, 18));
        maleGender.setBounds(250, 310, 100, 30);
        add(maleGender);

        femaleGender = new JRadioButton("Female");
        femaleGender.setFont(new Font("Arial", Font.PLAIN, 18));
        femaleGender.setBounds(360, 310, 100, 30);
        add(femaleGender);

        otherGender = new JRadioButton("Other");
        otherGender.setFont(new Font("Arial", Font.PLAIN, 18));
        otherGender.setBounds(495, 310, 100, 30);
        add(otherGender);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleGender);
        genderGroup.add(femaleGender);
        genderGroup.add(otherGender);

        JLabel emailID = new JLabel("E-mail ID:");
        emailID.setFont(new Font("Arial", Font.BOLD, 18));
        emailID.setBounds(80, 350, 100, 50);
        add(emailID);

        emailIDTF = new JTextField();
        emailIDTF.setFont(new Font("Arial", Font.PLAIN, 18));
        emailIDTF.setBounds(250, 360, 500, 30);
        emailIDTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(emailIDTF);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Arial", Font.BOLD, 18));
        maritalStatus.setBounds(80, 400, 150, 50);
        add(maritalStatus);

        singleMaritalStatus = new JRadioButton("Single");
        singleMaritalStatus.setFont(new Font("Arial", Font.PLAIN, 18));
        singleMaritalStatus.setBounds(250, 410, 100, 30);
        add(singleMaritalStatus);

        marriedMaritalStatus = new JRadioButton("Married");
        marriedMaritalStatus.setFont(new Font("Arial", Font.PLAIN, 18));
        marriedMaritalStatus.setBounds(360, 410, 100, 30);
        add(marriedMaritalStatus);

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(singleMaritalStatus);
        maritalStatusGroup.add(marriedMaritalStatus);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Arial", Font.BOLD, 19));
        address.setBounds(80, 450, 100, 50);
        add(address);

        addressTF = new JTextField();
        addressTF.setFont(new Font("Arial", Font.PLAIN, 18));
        addressTF.setBounds(250, 460, 500, 30);
        addressTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(addressTF);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setBounds(80, 500, 100, 50);
        add(city);

        cityTF = new JTextField();
        cityTF.setFont(new Font("Arial", Font.PLAIN, 18));
        cityTF.setBounds(250, 510, 500, 30);
        cityTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(cityTF);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setBounds(80, 550, 100, 50);
        add(state);

        stateTF = new JTextField();
        stateTF.setFont(new Font("Arial", Font.PLAIN, 18));
        stateTF.setBounds(250, 560, 500, 30);
        stateTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(stateTF);

        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Arial", Font.BOLD, 18));
        pinCode.setBounds(80, 600, 100, 50);
        add(pinCode);

        pinCodeTF = new JTextField();
        pinCodeTF.setFont(new Font("Arial", Font.PLAIN, 18));
        pinCodeTF.setBounds(250, 610, 500, 30);
        pinCodeTF.setBorder(new LineBorder(Color.BLACK, 1));
        add(pinCodeTF);

        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBounds(650, 670, 100, 40);
        next.setOpaque(true);
        next.setBorderPainted(false);
        next.setBackground(customColor);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setTitle("Sign Up Page 1");
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTF.getText();
        String fName = fNameTF.getText();
        String dob = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (maleGender.isSelected()) {
            gender = "Male";
        } else if (femaleGender.isSelected()) {
            gender = "Female";
        } else if (otherGender.isSelected()){
            gender = "Other";
        } else {
            gender = "";
        }

        String email = emailIDTF.getText();
        String maritalStatus = null;
        if (marriedMaritalStatus.isSelected()) {
            maritalStatus = "Married";
        } else if (singleMaritalStatus.isSelected()){
            maritalStatus = "Single";
        } else {
            maritalStatus = "";
        }

        String address = addressTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pin = pinCodeTF.getText();

        try {
            if (name.equals("") || fName.equals("") || dob.equals("") || gender.equals("") ||
                    email.equals("") || maritalStatus.equals("") || address.equals("") || city.equals("") ||
                    state.equals("") || pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the required fields");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fName + "', '"
                                + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '"
                                + address + "', '" + city + "', '" + state + "', '" + pin + "');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public long getRandomValue() {
        return random;
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
