import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener
{
    JLabel userNamJLabel,nameLabel;
    JTextField numberTextField,countryJTextField,addressTextField,phonetextFiled,emailtextfield;
    Choice idChoice;
    JRadioButton male,female;
    JButton addButton,backButton;
    ViewPackage(String username)
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

        JLabel PackLabel=new JLabel("Package");
        PackLabel.setBounds(50, 80, 100, 20);
        PackLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(PackLabel);

        JLabel viewPackage=new JLabel();
        viewPackage.setBounds(180, 80, 100, 20);
        viewPackage.setFont(new Font("Releway",Font.BOLD,15));
        add(viewPackage);

        JLabel personJLabel=new JLabel("Total Persons");
        personJLabel.setBounds(50, 130, 100, 20);
        personJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(personJLabel);

        JLabel personFiled=new JLabel();
        personFiled.setBounds(180, 130, 100, 20);
        personFiled.setFont(new Font("Releway",Font.BOLD,15));
        add(personFiled);

        JLabel idLabel=new JLabel("Id");
        idLabel.setBounds(50, 180, 100, 20);
        idLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(idLabel);

        JLabel idField=new JLabel();
        idField.setBounds(180, 180, 100, 20);
        idField.setFont(new Font("Releway",Font.BOLD,15));
        add(idField);

        JLabel numberLabel=new JLabel("Number");
        numberLabel.setBounds(50, 230, 100, 20);
        numberLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(numberLabel);

        JLabel numberField=new JLabel();
        numberField.setBounds(180, 230, 100, 20);
        numberField.setFont(new Font("Releway",Font.BOLD,15));
        add(numberField);

        JLabel phonLabel=new JLabel("Phone");
        phonLabel.setBounds(50, 280, 100, 20);
        phonLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(phonLabel);

        JLabel phoneField=new JLabel();
        phoneField.setBounds(180, 280, 100, 20);
        phoneField.setFont(new Font("Releway",Font.BOLD,15));
        add(phoneField);

        JLabel totalPrice=new JLabel("Total Price");
        totalPrice.setBounds(50, 320, 100, 20);
        totalPrice.setFont(new Font("Releway",Font.BOLD,15));
        add(totalPrice);

        JLabel priceField=new JLabel();
        priceField.setBounds(180, 320, 100, 20);
        priceField.setFont(new Font("Releway",Font.BOLD,15));
        add(priceField);

        


        

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(300, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 30, 300, 450);
        add(image);

         String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql = "select * from bookPackage where username='"+username+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                   userNamJLabel.setText(rs.getString("username"));
                   viewPackage.setText(rs.getString("selectPackage"));
                   personFiled.setText(rs.getString("totalPersons"));
                   idField.setText(rs.getString("id"));
                   numberField.setText(rs.getString("number"));
                   phoneField.setText(rs.getString("phone"));
                   priceField.setText(rs.getString("totalPrice"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
     
    }
    public static void main(String[] args) {
        new ViewPackage("");
    }
}
