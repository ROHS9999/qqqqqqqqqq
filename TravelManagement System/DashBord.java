import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashBord extends JFrame implements ActionListener
{
    JButton addPersonalDetails,updatePersonalDetails,viewDetails,deletePersonalDetails,bookPackage,viewPackage,viewHotal,bookHotal,ViewBookhotel;
    String username;
    DashBord(String username)
    {
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0, 102));
        p1.setBounds(0, 0, 1600,65);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10, 0, 70,70);
        p1.add(image);

        JLabel dashbord=new JLabel("DashBoard");
        dashbord.setBounds(90, 25, 150, 20);
        dashbord.setForeground(Color.WHITE);
        dashbord.setFont(new Font("Releway",Font.BOLD,22));
        p1.add(dashbord);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0, 102));
        p2.setBounds(0, 65, 300,900);
        add(p2);


        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 40, 300, 25);
        addPersonalDetails.setFont(new Font("Releway",Font.BOLD,13));
        addPersonalDetails.setBackground(new Color(0,0, 102));
        addPersonalDetails.setMargin(new Insets(0,0,0,100));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 70, 300, 25);
        updatePersonalDetails.setFont(new Font("Releway",Font.BOLD,13));
        updatePersonalDetails.setBackground(new Color(0,0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setMargin(new Insets(0,0,0,80));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewDetails=new JButton("View Customer");
        viewDetails.setBounds(0, 100, 300, 25);
        viewDetails.setFont(new Font("Releway",Font.BOLD,13));
        viewDetails.setBackground(new Color(0,0, 102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setMargin(new Insets(0, 0, 0, 140));
        viewDetails.addActionListener(this);
        p2.add(viewDetails);

        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 130, 300, 25);
        deletePersonalDetails.setFont(new Font("Releway",Font.BOLD,13));
        deletePersonalDetails.setBackground(new Color(0,0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 85));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        bookPackage=new JButton("Book Package");
        bookPackage.setBounds(0, 160, 300, 25);
        bookPackage.setFont(new Font("Releway",Font.BOLD,13));
        bookPackage.setBackground(new Color(0,0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setMargin(new Insets(0, 0, 0, 150));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage=new JButton("View Package");
        viewPackage.setBounds(0, 190, 300, 25);
        viewPackage.setFont(new Font("Releway",Font.BOLD,13));
        viewPackage.setBackground(new Color(0,0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setMargin(new Insets(0, 0, 0, 150));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);


        bookHotal=new JButton("Book Hotels");
        bookHotal.setBounds(0, 220, 300, 25);
        bookHotal.setFont(new Font("Releway",Font.BOLD,13));
        bookHotal.setBackground(new Color(0,0, 102));
        bookHotal.setForeground(Color.WHITE);
        bookHotal.setMargin(new Insets(0, 0, 0, 168));
        bookHotal.addActionListener(this);
        p2.add(bookHotal);


        ViewBookhotel=new JButton("View Booked Hotels");
        ViewBookhotel.setBounds(0, 250, 300, 25);
        ViewBookhotel.setFont(new Font("Releway",Font.BOLD,13));
        ViewBookhotel.setBackground(new Color(0,0, 102));
        ViewBookhotel.setForeground(Color.WHITE);
        ViewBookhotel.setMargin(new Insets(0, 0, 0, 113));
        ViewBookhotel.addActionListener(this);
        p2.add(ViewBookhotel);

    

        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBounds(300,65,1070,1000);
        p3.setBackground(Color.GREEN);
        add(p3);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image img2=img1.getImage().getScaledInstance(1070, 980,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel image2=new JLabel(img3);
        image2.setBounds(0,0, 1070,980);
        p3.add(image2);

        JLabel text=new JLabel("Travel And Tourism Management System");
        text.setBounds(70, 30, 1000, 35);
        text.setFont(new Font("Releway",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        image2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addPersonalDetails)
        {
            setVisible(true);
            new AddCustomer(username).setVisible(true);
        }
        else if(e.getSource()==viewDetails)
        {
            setVisible(true);
            new ViewCustomer(username).setVisible(true);
        }
        else if(e.getSource()==updatePersonalDetails)
        {
            setVisible(true);
            new UpdateCustomer(username).setVisible(true);
        }else if(e.getSource()==viewPackage)
        {
            setVisible(true);
            new ViewPackage(username).setVisible(true);
        }
        else if(e.getSource()==bookPackage)
        {
            setVisible(true);
            new BookPackage(username).setVisible(true);

        }
        else if(e.getSource()==bookHotal)
        {
            setVisible(true);
            new BookHotel(username).setVisible(true);
        }else if(e.getSource()==ViewBookhotel)
        {
            setVisible(true);
            new ViewBookHotel(username).setVisible(true);
        }
        else if(e.getSource()==deletePersonalDetails)
        {
            setVisible(true);
            new DeleateCustomer(username).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new DashBord("");
    }
}
