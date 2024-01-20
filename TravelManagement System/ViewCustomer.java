import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewCustomer extends JFrame implements ActionListener
{
    JButton backButton;
    ViewCustomer(String username)
    {
        setBounds(320,100,900,630);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel usernamLabel=new JLabel("UserName");
        usernamLabel.setBounds(20, 50,100, 20);
        usernamLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(usernamLabel);

        JLabel usernameField=new JLabel();
        usernameField.setBounds(150, 50,100, 20);
        usernameField.setFont(new Font("Releway",Font.BOLD,15));
        add(usernameField);

        JLabel idJLabel=new JLabel("Id");
        idJLabel.setBounds(20, 100,100, 20);
        idJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(idJLabel);

        JLabel idField=new JLabel();
        idField.setBounds(150, 100,100, 20);
        idField.setFont(new Font("Releway",Font.BOLD,15));
        add(idField);

        JLabel numberJLabel=new JLabel("Number");
        numberJLabel.setBounds(20, 150,100, 20);
        numberJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(numberJLabel);

        JLabel numberField=new JLabel();
        numberField.setBounds(150, 150,100, 20);
        numberField.setFont(new Font("Releway",Font.BOLD,15));
        add(numberField);

        JLabel nameJLabel=new JLabel("Name");
        nameJLabel.setBounds(20, 200,100, 20);
        nameJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(nameJLabel);

        JLabel nameField=new JLabel();
        nameField.setBounds(150, 200,100, 20);
        nameField.setFont(new Font("Releway",Font.BOLD,15));
        add(nameField);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(20, 250,100, 20);
        gender.setFont(new Font("Releway",Font.BOLD,15));
        add(gender);

        JLabel genderField=new JLabel();
        genderField.setBounds(150, 250,100, 20);
        genderField.setFont(new Font("Releway",Font.BOLD,15));
        add(genderField);

        JLabel countryJLabel=new JLabel("Country");
        countryJLabel.setBounds(400, 50,100, 20);
        countryJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(countryJLabel);
        
        JLabel countryField=new JLabel();
        countryField.setBounds(550, 50,100, 20);
        countryField.setFont(new Font("Releway",Font.BOLD,15));
        add(countryField);

        JLabel addressJLabel=new JLabel("Address");
        addressJLabel.setBounds(400, 100,100, 20);
        addressJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(addressJLabel);
        
        JLabel addressField=new JLabel();
        addressField.setBounds(550, 100,100, 20);
        addressField.setFont(new Font("Releway",Font.BOLD,15));
        add(addressField);

        
        JLabel phonJLabel=new JLabel("Phone");
        phonJLabel.setBounds(400, 150,100, 20);
        phonJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(phonJLabel);
        
        JLabel phoneField=new JLabel();
        phoneField.setBounds(550, 150,100, 20);
        phoneField.setFont(new Font("Releway",Font.BOLD,15));
        add(phoneField);

        JLabel emaiJLabel=new JLabel("Email");
        emaiJLabel.setBounds(400, 200,100, 20);
        emaiJLabel.setFont(new Font("Releway",Font.BOLD,15));
        add(emaiJLabel);
        
        JLabel emailsField=new JLabel();
        emailsField.setBounds(550, 200,150, 20);
        emailsField.setFont(new Font("Releway",Font.BOLD,15));
        add(emailsField);

        

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100, 400, 600, 200);
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
                    usernameField.setText(rs.getString("username"));   
                    idField.setText(rs.getString("id"));
                    numberField.setText(rs.getString("number"));
                    nameField.setText(rs.getString("name"));
                    genderField.setText(rs.getString("gender"));
                    countryField.setText(rs.getString("country"));
                    addressField.setText(rs.getString("address"));
                    phoneField.setText(rs.getString("phone"));
                    emailsField.setText(rs.getString("email"));
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
        new ViewCustomer("");
    }
}
