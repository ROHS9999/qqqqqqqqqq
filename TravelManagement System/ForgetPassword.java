import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField usernameTextField, nameJTextField, securityJTextField, answerJTextField, passworJTextField;
    JButton search, retrieve, back;

    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel userNamLabel = new JLabel("UserName");
        userNamLabel.setBounds(40, 20, 100, 25);
        userNamLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(userNamLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(150, 20, 200, 22);
        usernameTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(usernameTextField);

        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(360, 20, 100, 22);
        search.addActionListener(this);
        p1.add(search);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 60, 100, 25);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(nameLabel);

        nameJTextField = new JTextField();
        nameJTextField.setBounds(150, 60, 200, 22);
        nameJTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameJTextField);

        JLabel securityJLabel = new JLabel("Security Question");
        securityJLabel.setBounds(40, 100, 110, 25);
        securityJLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        p1.add(securityJLabel);

        securityJTextField = new JTextField();
        securityJTextField.setBounds(150, 100, 200, 22);
        securityJTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(securityJTextField);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40, 140, 100, 25);
        answer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(answer);

        answerJTextField = new JTextField();
        answerJTextField.setBounds(150, 140, 200, 22);
        answerJTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerJTextField);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.BLACK);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(360, 140, 100, 22);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40, 180, 100, 25);
        Password.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(Password);

        passworJTextField = new JTextField();
        passworJTextField.setBounds(150, 180, 200, 22);
        passworJTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passworJTextField);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 220, 100, 22);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String userName=usernameTextField.getText();
        String answerr=answerJTextField.getText();
        if (e.getSource() == back) {
            setVisible(false);
            new Login("").setVisible(true);
        } else if (e.getSource() == search) 
        {
            String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

                String sql = "select * from account where username='" +userName+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    nameJTextField.setText(rs.getString("name"));
                    securityJTextField.setText(rs.getString("security"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
        else if(e.getSource()==retrieve)
        {
            String DB_URL = "jdbc:mysql://localhost:3306/Travel_And_Tourism";
            String USER = "root";
            String PASS = "";
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

                String sql = "select * from account where answer='" +answerr+"'And username='" +userName+"'";
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    passworJTextField.setText(rs.getString("password"));
                }
                
            } catch (Exception ob) {
                ob.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
