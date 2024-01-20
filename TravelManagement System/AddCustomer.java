import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JLabel userNamJLabel,nameLabel;
    JTextField numberTextField,countryJTextField,addressTextField,phonetextFiled,emailtextfield;
    Choice idChoice;
    JRadioButton male,female;
    JButton addButton,backButton;
    AddCustomer(String usernname)
    {
        setBounds(300,100,850,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel usernameLaJLabel=new JLabel("Username");
        usernameLaJLabel.setBounds(50, 30, 100, 20);
        usernameLaJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(usernameLaJLabel);

        userNamJLabel=new JLabel();
        userNamJLabel.setBounds(180, 30, 100, 20);
        userNamJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(userNamJLabel);

        JLabel idJLabel=new JLabel("Id");
        idJLabel.setBounds(50, 80, 100, 20);
        idJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(idJLabel);

        idChoice=new Choice();
        idChoice.setBounds(180, 80,180,20);
        idChoice.add("Passport");
        idChoice.add("Aadhar Card");
        idChoice.add("Pan Card ");
        idChoice.add("Ration Card");
        add(idChoice);

        JLabel Number=new JLabel("Number");
        Number.setBounds(50, 130, 100, 20);
        Number.setFont(new Font("Releway",Font.BOLD,15));
        add(Number);

        numberTextField=new JTextField();
        numberTextField.setBounds(180,130,180,20);
        add(numberTextField);

        JLabel namefield=new JLabel("Name");
        namefield.setBounds(50, 180, 100, 20);
        namefield.setFont(new Font("Releway",Font.BOLD,15));
        add(namefield);

        nameLabel=new JLabel();
        nameLabel.setBounds(180, 180, 100, 20);
        nameLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(nameLabel);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(50, 230, 100, 20);
        gender.setFont(new Font("Releway",Font.BOLD,15));
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(180,230,70,20);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(250,230,70,20);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup b1=new ButtonGroup();
        b1.add(male);
        b1.add(female);

        JLabel country=new JLabel("Country");
        country.setBounds(50, 280, 100, 20);
        country.setFont(new Font("Releway",Font.BOLD,15));
        add(country);

        countryJTextField=new JTextField();
        countryJTextField.setBounds(180,280,180,20);
        add(countryJTextField);

        JLabel address=new JLabel("Address");
        address.setBounds(50, 330, 100, 20);
        address.setFont(new Font("Releway",Font.BOLD,15));
        add(address);

        addressTextField=new JTextField();
        addressTextField.setBounds(180,330,180,20);
        add(addressTextField);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(50, 380, 100, 20);
        phone.setFont(new Font("Releway",Font.BOLD,15));
        add(phone);

        phonetextFiled=new JTextField();
        phonetextFiled.setBounds(180,380,180,20);
        add(phonetextFiled);

        JLabel email=new JLabel("Email");
        email.setBounds(50, 430, 100, 20);
        email.setFont(new Font("Releway",Font.BOLD,15));
        add(email);

        emailtextfield=new JTextField();
        emailtextfield.setBounds(180,430,180,20);
        add(emailtextfield);

        addButton=new JButton("Add");
        addButton.setBounds(80, 480, 100, 25);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Releway",Font.BOLD,15));
        addButton.addActionListener(this);
        add(addButton);


       
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(300, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 30, 300, 600);
        add(image);

         String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql = "select * from account where username='"+usernname+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                   userNamJLabel.setText(rs.getString("username"));
                   nameLabel.setText(rs.getString("name"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String uname=userNamJLabel.getText();
        String id=idChoice.getSelectedItem();
        String number=numberTextField.getText();
        String name=nameLabel.getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="male";
        }
        else 
        {
            gender="female";
        }
        String country=countryJTextField.getText();
        String address=addressTextField.getText();
        String phone=phonetextFiled.getText();
        String email=emailtextfield.getText();
        
        if(e.getSource()==addButton)
        {
             String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql ="insert into customer values('"+uname+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"customer add succesfully...");
                setVisible(false);
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
       
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
