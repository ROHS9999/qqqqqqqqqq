import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener
{
    JTextField userNamTextField,namTextField,passworTextField,answerTextField;
    Choice security;
    JButton backButton,createbButton;
    Signup()
    {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel userNamLabel=new JLabel("UserName");
        userNamLabel.setFont(new Font("Releway",Font.BOLD,20));
        userNamLabel.setBounds(50,20,125,25);
        p1.add(userNamLabel);

        userNamTextField=new JTextField();
        userNamTextField.setBounds(180,20, 280, 25);
        userNamTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(userNamTextField);


        JLabel namLabel=new JLabel("Name");
        namLabel.setBounds(50, 60, 125, 25);
        namLabel.setFont(new Font("Releway",Font.BOLD,20));
        p1.add(namLabel);

        namTextField=new JTextField();
        namTextField.setBorder(BorderFactory.createEmptyBorder());
        namTextField.setBounds(180,60, 280, 25);
        p1.add(namTextField);

        JLabel passwordJLabel=new JLabel("Password");
        passwordJLabel.setBounds(50, 100, 125, 25);
        passwordJLabel.setFont(new Font("Releway",Font.BOLD,20));
        p1.add(passwordJLabel);

        passworTextField=new JTextField();
        passworTextField.setBorder(BorderFactory.createEmptyBorder());
        passworTextField.setBounds(180,100, 280, 25);
        p1.add(passworTextField);

        JLabel SecurityLabel =new JLabel("Security Ques.");
        SecurityLabel.setBounds(50, 140, 125, 15);
        SecurityLabel.setFont(new Font("Releway",Font.BOLD,15));
        p1.add(SecurityLabel);

        security=new Choice();
        security.add("Fav Character from The Boys");
        security.add("Fav Marvel superhero");
        security.add("Your Lucky Number");
        security.add("Your childhood superhero");
        security.setBounds(180, 140,280, 25);
        p1.add(security);

        JLabel anserJLabel=new JLabel("Answer");
        anserJLabel.setBounds(50, 180, 125, 25);
        anserJLabel.setFont(new Font("Releway",Font.BOLD,20));
        p1.add(anserJLabel);

        answerTextField=new JTextField();
        answerTextField.setBorder(BorderFactory.createEmptyBorder());
        answerTextField.setBounds(180,180, 280, 25);
        p1.add(answerTextField);


        createbButton=new JButton("Create");
        createbButton.setBounds(50,240,100, 25);
        createbButton.setBackground(Color.BLACK);
        createbButton.setForeground(Color.WHITE);
        createbButton.addActionListener(this);
        p1.add(createbButton);


        backButton=new JButton("Back");
        backButton.setBounds(180,240,110, 25);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        p1.add(backButton);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,250,250);
        add(image); 
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String userName=userNamTextField.getText();
        String name=namTextField.getText();
        String password=passworTextField.getText();
        String quesation=security.getSelectedItem();
        String answer=answerTextField.getText();
        if(e.getSource()==createbButton)
        {
           String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
           String USER = "root";
           String PASS = "";
    try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
  
        String sql="insert into account value('"+userName+"','"+name+"','"+password+"','"+quesation+"','"+answer+"')";
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Account Create Successfully...");
      } catch (Exception ob) {
        ob.printStackTrace();
      } 
          setVisible(false);
          new Login("").setVisible(true);
        }
        if(e.getSource()==backButton)
        {
            setVisible(false);
            new Login("").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
