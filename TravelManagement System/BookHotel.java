import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;
public class BookHotel extends JFrame implements ActionListener
{
    JTextField totalPersonTExtField,NumberOfTextfield;
    JButton cheakPrice,bookPackageButton,back;
    JLabel usernameField,IdField,NumberField,phoneField,PriceField;
    Choice selectChoice;
    BookHotel(String username)
    {
        setBounds(300,150,900, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("BOOK HOTEL");
        text.setFont(new Font("Releway",Font.BOLD,22));
        text.setBounds(100,20,200,20);
        add(text);

        JLabel usernamLabel=new JLabel("Username");
        usernamLabel.setFont(new Font("Releway",Font.BOLD,15));
        usernamLabel.setBounds(50,80,100,20);
        add(usernamLabel);

        usernameField=new JLabel();
        usernameField.setFont(new Font("Releway",Font.BOLD,15));
        usernameField.setBounds(200,80,100,20);
        add(usernameField);

        JLabel selectPackagLabel=new JLabel("Select Hotel");
        selectPackagLabel.setFont(new Font("Releway",Font.BOLD,15));
        selectPackagLabel.setBounds(50,120,120,20);
        add(selectPackagLabel);

        selectChoice=new Choice();
        selectChoice.setBounds(200, 120, 150, 20);
        selectChoice.add("Taj Hotel");
        selectChoice.add("Bhanwar Singh Palace");
        selectChoice.add("5 Star Hotel");
        add(selectChoice);

        JLabel person=new JLabel("Total Persons");
        person.setFont(new Font("Releway",Font.BOLD,15));
        person.setBounds(50,160,100,20);
        add(person);

        totalPersonTExtField=new JTextField();
        totalPersonTExtField.setFont(new Font("Releway",Font.BOLD,15));
        totalPersonTExtField.setBounds(200,160,150,20);
        add(totalPersonTExtField);
        setVisible(true);

        JLabel noOfday=new JLabel("No. Of Days");
        noOfday.setFont(new Font("Releway",Font.BOLD,15));
        noOfday.setBounds(50,200,100,20);
        add(noOfday);

        NumberOfTextfield=new JTextField();
        NumberOfTextfield.setFont(new Font("Releway",Font.BOLD,15));
        NumberOfTextfield.setBounds(200,200,150,20);
        add(NumberOfTextfield);
        setVisible(true);

        JLabel ID=new JLabel("ID");
        ID.setFont(new Font("Releway",Font.BOLD,15));
        ID.setBounds(50,240,100,20);
        add(ID);

        IdField=new JLabel();
        IdField.setFont(new Font("Releway",Font.BOLD,15));
        IdField.setBounds(200,240,150,20);
        add(IdField);

        JLabel Number=new JLabel("Number");
        Number.setFont(new Font("Releway",Font.BOLD,15));
        Number.setBounds(50,280,100,20);
        add(Number);

        NumberField=new JLabel();
        NumberField.setFont(new Font("Releway",Font.BOLD,15));
        NumberField.setBounds(200,280,150,20);
        add(NumberField);

        JLabel Phone=new JLabel("Phone");
        Phone.setFont(new Font("Releway",Font.BOLD,15));
        Phone.setBounds(50,320,100,20);
        add(Phone);

        phoneField=new JLabel();
        phoneField.setFont(new Font("Releway",Font.BOLD,15));
        phoneField.setBounds(200,320,150,20);
        add(phoneField);

        JLabel TotalPrice=new JLabel("TotalPrice");
        TotalPrice.setFont(new Font("Releway",Font.BOLD,15));
        TotalPrice.setBounds(50,360,100,20);
        add(TotalPrice);

        PriceField=new JLabel();
        PriceField.setFont(new Font("Releway",Font.BOLD,15));
        PriceField.setBounds(200,360,150,20);
        add(PriceField);

        cheakPrice=new JButton("Check Price");
        cheakPrice.setBounds(100,400,150,25);
        cheakPrice.setForeground(Color.WHITE);
        cheakPrice.setBackground(Color.BLACK);
        cheakPrice.addActionListener(this);
        add(cheakPrice);


        bookPackageButton=new JButton("Book Hotel");
        bookPackageButton.setBounds(300,400,150,25);
        bookPackageButton.setForeground(Color.WHITE);
        bookPackageButton.setBackground(Color.BLACK);
        bookPackageButton.addActionListener(this);
        add(bookPackageButton);

       

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,50,450,300);
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
                    IdField.setText(rs.getString("id"));
                    NumberField.setText(rs.getString("number"));
                    phoneField.setText(rs.getString("phone"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
    }
     public void actionPerformed(ActionEvent e)
     {
        String usename=usernameField.getText();
        String choocepackage=selectChoice.getSelectedItem();
        String Person=totalPersonTExtField.getText();
        String id=IdField.getText();
        String number=NumberField.getText();
        String phone=phoneField.getText();
        String price=PriceField.getText();
        if(e.getSource()==cheakPrice)
        {
            String pack=selectChoice.getSelectedItem();
            int cost=0;
            if(pack.equals("Taj Hotel"))
            {
                cost+=1000;
            }else if(pack.equals("Bhanwar Singh Palace"))
            {
                cost+=2000;
            }else
            {
                cost+=3000;
            }
            int persons=Integer.parseInt(totalPersonTExtField.getText());
            int day=Integer.parseInt(NumberOfTextfield.getText());
            cost*=persons;
            day *=cost;
            PriceField.setText("Rs "+day);
        }
        else if(e.getSource()==bookPackageButton)
        {
             String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql ="insert into bookHotel values('"+usename+"','"+choocepackage+"','"+Person+"','"+NumberOfTextfield.getText()+"','"+id+"','"+number+"','"+phone+"','"+price+"')";
                stmt.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"book hotel succefully...");
               setVisible(false);
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
        

     }
            
    public static void main(String[] args) {
        new BookHotel("");
    }
}
