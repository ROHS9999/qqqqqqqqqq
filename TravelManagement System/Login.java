import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton signup, forgetPass, login;
    JTextField userNamTextField,passwordJTextField;
    String username;
    Login(String username) {
        this.username=username;
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel userNamLabel = new JLabel("UserName");
        userNamLabel.setBounds(60, 20, 100, 25);
        userNamLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(userNamLabel);

        userNamTextField = new JTextField();
        userNamTextField.setBounds(60, 50, 300, 25);
        userNamTextField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNamTextField);

        JLabel passwordJLabel = new JLabel("Password");
        passwordJLabel.setBounds(60, 100, 150, 25);
        passwordJLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        p2.add(passwordJLabel);

        passwordJTextField = new JTextField();
        passwordJTextField.setBounds(60, 150, 300, 25);
        passwordJTextField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordJTextField);

        login= new JButton("Login");
        login.setBounds(60, 200, 100, 25);
        login.setBackground(new Color(131, 193, 233));
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 100, 25);
        signup.setBackground(new Color(131, 193, 233));
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        p2.add(signup);

        forgetPass = new JButton("Forget Password");
        forgetPass.setBounds(130, 250, 110, 25);
        forgetPass.setBackground(new Color(131, 193, 233));
        forgetPass.setBorder(BorderFactory.createEmptyBorder());
        forgetPass.setForeground(Color.WHITE);
        forgetPass.addActionListener(this);
        p2.add(forgetPass);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username=userNamTextField.getText();
        String passwords=passwordJTextField.getText();
        if (e.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        } else if (e.getSource() == forgetPass) {
            setVisible(false);
            new ForgetPassword().setVisible(true);
        } else if (e.getSource() == login) {
            String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                String sql = "select * from account where username='"+username+"'And password='"+passwords+"'";
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next())
                {
                    setVisible(false);
                    new DashBord(username).setVisible(true); 
                }else
                {
                    JOptionPane.showMessageDialog(null,"inccorect username and password");
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login("");
    }
}