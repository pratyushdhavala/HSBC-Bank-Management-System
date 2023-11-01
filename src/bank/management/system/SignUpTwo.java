package bank.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField enterPAN, enterAadhaar;
    JComboBox chooseReligion, chooseCategory, chooseEducation, chooseOccupation, chooseIncome;
    JRadioButton seniorYes, seniorNo, existsYes, existsNo;
    String formno;
    SignUpTwo(String formno) {
        this.formno = formno;
        //to deactivate the default layout settings
        setLayout(null);

        //hsbc custom red color
        Color customColor = new Color(238, 53, 36);

        //to get the same form number used in SignUpOne window

        //window heading: Application No. + random number
        JLabel formNumber = new JLabel("Application No." + formno);
        formNumber.setFont(new Font("Arial", Font.BOLD, 24));
        formNumber.setBounds(305, 50, 240, 50);
        add(formNumber);

        //page number
        JLabel pageNoTwo = new JLabel("Page 2 of 3");
        pageNoTwo.setFont(new Font("Arial", Font.PLAIN, 16));
        pageNoTwo.setBounds(720, 10, 100, 50);
        add(pageNoTwo);

        //window sub-heading: Additonal Details
        JLabel additionalDetails = new JLabel("Additonal Details");
        additionalDetails.setFont(new Font("Arial", Font.BOLD, 20));
        additionalDetails.setBounds(80, 100, 180, 50);
        add(additionalDetails);

        //religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Arial", Font.BOLD, 18));
        religion.setBounds(80, 150, 150, 50);
        add(religion);

        //list of religions
        String[] validReligion = {"Hinduism", "Islam", "Christianity", "Judaism", "Sikhism", "Buddhism", "Other"};

        //dropdown menu to choose a religion
        chooseReligion = new JComboBox(validReligion);
        chooseReligion.setFont(new Font("Arial", Font.PLAIN, 15));
        chooseReligion.setBounds(250, 150, 500, 50);
        chooseReligion.setBackground(Color.WHITE);
        add(chooseReligion);

        //category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Arial", Font.BOLD, 18));
        category.setBounds(80, 200, 150, 50);
        add(category);

        //list of categories
        String[] validCategory = {"General", "OBC", "SC/ST", "Other"};

        //dropdown menu to choose a category
        chooseCategory = new JComboBox(validCategory);
        chooseCategory.setFont(new Font("Arial", Font.PLAIN, 15));
        chooseCategory.setBounds(250, 200, 500, 50);
        chooseCategory.setBackground(Color.WHITE);
        add(chooseCategory);

        //income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Arial", Font.BOLD, 18));
        income.setBounds(80, 250, 150, 50);
        add(income);

        //list of income categories
        String[] validIncome = {"N/A", "< 5,00,000", "< 10,00,000", "Upto 20,00,000"};

        //dropdown menu to choose income category
        chooseIncome = new JComboBox(validIncome);
        chooseIncome.setFont(new Font("Arial", Font.PLAIN, 15));
        chooseIncome.setBounds(250, 250, 500, 50);
        chooseIncome.setBackground(Color.WHITE);
        add(chooseIncome);

        //educational qualifications
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Arial", Font.BOLD, 18));
        education.setBounds(80, 300, 150, 50);
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Arial", Font.BOLD, 18));
        qualification.setBounds(80, 325, 150, 50);
        add(qualification);

        //list of educational qualifications
        String[] validEducation = {"Doctorate", "Masters", "Bachelors", "Diploma", "High school graduate"};

        //dropdown menu to choose a educational qualification
        chooseEducation = new JComboBox(validEducation);
        chooseEducation.setFont(new Font("Arial", Font.PLAIN, 15));
        chooseEducation.setBounds(250, 300, 500, 50);
        chooseEducation.setBackground(Color.WHITE);
        add(chooseEducation);

        //occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Arial", Font.BOLD, 18));
        occupation.setBounds(80, 375, 150, 50);
        add(occupation);

        //list of occupations
        String[] validOccupation = {"Corporate", "Self Employed", "Business", "Entrepreneur", "Student", "Others"};

        //dropdown menu to choose occupation
        chooseOccupation = new JComboBox(validOccupation);
        chooseOccupation.setFont(new Font("Arial", Font.PLAIN, 15));
        chooseOccupation.setBounds(250, 375, 500, 50);
        chooseOccupation.setBackground(Color.WHITE);
        add(chooseOccupation);

        //pan number
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Arial", Font.BOLD, 18));
        pan.setBounds(80, 425, 150, 50);
        add(pan);

        //text field to enter pan number
        enterPAN = new JTextField();
        enterPAN.setFont(new Font("Arial", Font.PLAIN, 18));
        enterPAN.setBounds(250, 435, 500, 30);
        enterPAN.setBorder(new LineBorder(Color.BLACK, 1));
        add(enterPAN);

        //aadhaar number
        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Arial", Font.BOLD, 18));
        aadhaar.setBounds(80, 475, 200, 50);
        add(aadhaar);

        //text field to enter aadhaar card
        enterAadhaar = new JTextField();
        enterAadhaar.setFont(new Font("Arial", Font.PLAIN, 18));
        enterAadhaar.setBounds(250, 485, 500, 30);
        enterAadhaar.setBorder(new LineBorder(Color.BLACK, 1));
        add(enterAadhaar);

        //senior citizen
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Arial", Font.BOLD, 18));
        senior.setBounds(80, 525, 200, 50);
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setFont(new Font("Arial", Font.PLAIN, 18));
        seniorYes.setBounds(250, 525, 100, 50);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setFont(new Font("Arial", Font.PLAIN, 18));
        seniorNo.setBounds(360, 525, 100, 50);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        //existing account
        JLabel exists = new JLabel("Existing Account:");
        exists.setFont(new Font("Arial", Font.BOLD, 18));
        exists.setBounds(80, 575, 200, 50);
        add(exists);

        existsYes = new JRadioButton("Yes");
        existsYes.setFont(new Font("Arial", Font.PLAIN, 18));
        existsYes.setBounds(250, 575, 100, 50);
        add(existsYes);

        existsNo = new JRadioButton("No");
        existsNo.setFont(new Font("Arial", Font.PLAIN, 18));
        existsNo.setBounds(360, 575, 100, 50);
        add(existsNo);

        ButtonGroup existsGroup = new ButtonGroup();
        existsGroup.add(existsYes);
        existsGroup.add(existsNo);

        JButton next = new JButton("next");
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBounds(625, 670, 125, 40);
        next.setOpaque(true);
        next.setBorderPainted(false);
        next.setBackground(customColor);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        setTitle("Sign Up Page 2");
        getContentPane().setBackground(Color.WHITE);


    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) chooseReligion.getSelectedItem();
        String category = (String) chooseCategory.getSelectedItem();
        String income = (String) chooseIncome.getSelectedItem();
        String education = (String) chooseEducation.getSelectedItem();
        String occupation = (String) chooseOccupation.getSelectedItem();
        String panNumber = enterPAN.getText();
        String aadhaarNumber = enterAadhaar.getText();

        String seniorCitizen = null;
        if (seniorYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (seniorNo.isSelected()) {
            seniorCitizen = "No";
        } else {
            seniorCitizen = "";
        }

        String existingAccount = null;
        if (existsYes.isSelected()) {
            existingAccount = "Yes";
        } else if (existsNo.isSelected()) {
            existingAccount = "No";
        } else {
            existingAccount = "";
        }

        try {
            if (religion.equals("") || category.equals("") || income.equals("") || education.equals("") ||
                occupation.equals("") || panNumber.equals("") || aadhaarNumber.equals("") ||
                seniorCitizen.equals("") || existingAccount.equals("")) {

                JOptionPane.showMessageDialog(null, "Please enter the required fields");

            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values ('" + formno + "', '" + religion + "', '" + category +
                                "', '" + income + "', '" + education + "', '" +  occupation + "', '" +
                                panNumber + "', '" + aadhaarNumber + "', '" + seniorCitizen + "', '" +
                                existingAccount + "');";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
