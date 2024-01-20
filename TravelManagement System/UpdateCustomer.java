import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener
{
    JLabel userNamJLabel,nameLabel;
    JTextField numberTextField,countryJTextField,addressTextField,phonetextFiled,emailtextfield,tfid,tfgender;
    Choice idChoice;
    JRadioButton male,female;
    JButton addButton,backButton;
    String username;
    UpdateCustomer(String username)
    {
        this.username=username;

        setBounds(300,100,850,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,400,20);
        text.setFont(new Font("Releway",Font.BOLD,22));
        add(text);

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

        tfid=new JTextField();
        tfid.setBounds(180,80,180,20);
        add(tfid);

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

        tfgender=new JTextField();
        tfgender.setBounds(180,230,180,20);
        add(tfgender);

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

        addButton=new JButton("Update");
        addButton.setBounds(80, 480, 100, 25);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Releway",Font.BOLD,15));
        addButton.addActionListener(this);
        add(addButton);


       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(250, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 60, 250, 450);
        add(image);

         String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql ="select * from customer where username='"+username+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                   userNamJLabel.setText(rs.getString("username"));
                   nameLabel.setText(rs.getString("name"));
                   tfid.setText(rs.getString("id"));
                   numberTextField.setText(rs.getString("number"));
                   tfgender.setText(rs.getString("gender"));
                   countryJTextField.setText(rs.getString("country"));
                   addressTextField.setText(rs.getString("address"));
                   phonetextFiled.setText(rs.getString("phone"));
                   emailtextfield.setText(rs.getString("email"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String uname=userNamJLabel.getText();
        String id=tfid.getText();
        String number=numberTextField.getText();
        String name=nameLabel.getText();
        String gender=tfgender.getText();
        
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
                String sql ="update customer set usename='"+uname+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"customer update succesfully...");
                setVisible(false);
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
