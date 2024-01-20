import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ViewBookHotel extends JFrame implements ActionListener
{
    JButton back,cheakData;
    JLabel priceField,phoneField,numberField,idField,personsField,hotelNameField,noofdayField,usernameField;
    ViewBookHotel(String username)
    {
        
        setBounds(250,80,1000,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("VIEW BOOK HOTEL DETAILS");
        text.setFont(new Font("Releway",Font.BOLD,25));
        text.setBounds(50,20,400,25);
        add(text);

        JLabel usernamLabel=new JLabel("Username");
        usernamLabel.setBounds(20, 100, 200,15);
        usernamLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(usernamLabel);

        usernameField=new JLabel();
        usernameField.setBounds(250, 100, 100,22);
        usernameField.setFont(new Font("Releway",Font.BOLD,15));
        add(usernameField);


        JLabel hotelNamLabel=new JLabel("Hotel Name");
        hotelNamLabel.setBounds(20, 150, 200,15);
        hotelNamLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(hotelNamLabel);
        
        hotelNameField=new JLabel();
        hotelNameField.setBounds(250, 150, 200,15);
        hotelNameField.setFont(new Font("Releway",Font.BOLD,15));
        add(hotelNameField);


        JLabel personsJLabel=new JLabel("Persons");
        personsJLabel.setBounds(20, 200, 200,15);
        personsJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(personsJLabel);
        
         personsField=new JLabel();
        personsField.setBounds(250, 200, 200,15);
        personsField.setFont(new Font("Releway",Font.BOLD,15));
        add(personsField);

        JLabel noofdayJLabel=new JLabel("No.Of Day");
        noofdayJLabel.setBounds(20, 250, 200,15);
        noofdayJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(noofdayJLabel);
        
         noofdayField=new JLabel();
        noofdayField.setBounds(250, 250, 200,15);
        noofdayField.setFont(new Font("Releway",Font.BOLD,15));
        add(noofdayField);

        JLabel idLabel=new JLabel("Id");
        idLabel.setBounds(20, 300, 200,15);
        idLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(idLabel);
        
         idField=new JLabel();
        idField.setBounds(250, 300, 200,15);
        idField.setFont(new Font("Releway",Font.BOLD,15));
        add(idField);

        JLabel numberJLabel=new JLabel("Number");
        numberJLabel.setBounds(20, 350, 200,15);
        numberJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(numberJLabel);
        
         numberField=new JLabel();
        numberField.setBounds(250, 350, 200,15);
        numberField.setFont(new Font("Releway",Font.BOLD,15));
        add(numberField);

        JLabel phonLabel=new JLabel("Phone");
        phonLabel.setBounds(20, 400, 200,15);
        phonLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(phonLabel);
        
         phoneField=new JLabel();
        phoneField.setBounds(250, 400, 200,15);
        phoneField.setFont(new Font("Releway",Font.BOLD,15));
        add(phoneField);

        JLabel priceLabel=new JLabel("Price");
        priceLabel.setBounds(20, 450, 200,15);
        priceLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(priceLabel);
        
         priceField=new JLabel();
        priceField.setBounds(250, 450, 200,15);
        priceField.setFont(new Font("Releway",Font.BOLD,15));
        add(priceField);

       

       String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql ="select * from bookhotel where Username='"+username+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                   usernameField.setText(rs.getString("Username"));
                   hotelNameField.setText(rs.getString("Hotel"));
                   personsField.setText(rs.getString("TotalPersons"));

                   noofdayField.setText(rs.getString("No.Of.Day"));
                   idField.setText(rs.getString("Id"));
                   numberField.setText(rs.getString("Number"));

                   phoneField.setText(rs.getString("Phone"));
                   priceField.setText(rs.getString("Price"));
                } 
                System.out.println("data not found");
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hotel9.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420, 50, 500, 500);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
       
       
    }
    public static void main(String[] args) {
        new ViewBookHotel("");
    }
}
