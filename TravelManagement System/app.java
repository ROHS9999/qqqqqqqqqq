import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class App extends JFrame implements Runnable
{
      Thread th;
      JLabel image2,image3,l2,l3,l4,l5,l6,l7,l8,l9;
      public void run()
      {
            try{
            image2.setVisible(true);
            Thread.sleep(2800);
            image2.setVisible(false);

           
            image3.setVisible(true);
            Thread.sleep(2800);
            image3.setVisible(false);

            l2.setVisible(true);
            Thread.sleep(2800);
            l2.setVisible(false);

            l3.setVisible(true);
            Thread.sleep(2800);
            l3.setVisible(false);

            l4.setVisible(true);
            Thread.sleep(2800);
            l4.setVisible(false);

            l5.setVisible(true);
            Thread.sleep(2800);
            l5.setVisible(false);

            l6.setVisible(true);
            Thread.sleep(2800);
            l6.setVisible(false);

            l7.setVisible(true);
            Thread.sleep(2800);
            l7.setVisible(false);

            l8.setVisible(true);
            Thread.sleep(2800);
            l8.setVisible(false);

            l9.setVisible(true);
            Thread.sleep(10000);
            l9.setVisible(false);

            this.setVisible(false);
            }catch(Exception e)
            {
                  System.out.print(e);
            }
           
      }
      App() {

            setTitle("Travel_And_Tourism");
            setVisible(true);
            setSize(800, 700);
            setLayout(null);

            JPanel p1 = new JPanel();
            p1.setBounds(0, 0, 1400, 800);
            p1.setBackground(Color.white);
            p1.setLayout(null);
            add(p1);

            JMenuBar hotelBooking = new JMenuBar();

            JMenu loginPage = new JMenu("Login Page");

            JMenuItem loginCustomer = new JMenuItem("Login Customer");

            loginPage.add(loginCustomer);

            hotelBooking.add(loginPage);

            setJMenuBar(hotelBooking);

            loginCustomer.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        new Login("");
                  }
            });
            JLabel welcome=new JLabel("WELCOME");
            welcome.setBounds(350, 100, 650, 40);
            welcome.setFont(new Font("Releway",Font.BOLD,30));  
            p1.add(welcome);


            JLabel text=new JLabel("Travel And Tourism Management System ");
            text.setBounds(350, 150, 650, 40);
            text.setFont(new Font("Releway",Font.BOLD,30));  
            p1.add(text);

            
            th=new Thread(this);
           
            ImageIcon img1 = new ImageIcon(getClass().getResource("/icons/dest1.jpeg"));
            Image Img2=img1.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon img3=new ImageIcon(Img2);
            image2=new JLabel(img3);
            image2.setBounds(0,300,1380,370);
            p1.add(image2);

            setLayout(null);

            ImageIcon ph1=new ImageIcon(ClassLoader.getSystemResource("icons/dest2.png"));
            Image ph2=ph1.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon ph3=new ImageIcon(ph2);
            image3=new JLabel(ph3);
            image3.setBounds(0,300,1380,370);
            p1.add(image3);
            image3.setVisible(false);

            ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icons/dest3.jpg"));
            Image j1=l1.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k1=new ImageIcon(j1);
            l2=new JLabel(k1);
            l2.setBounds(0,300,1380,370);
            p1.add(l2);
            l2.setVisible(false);

            ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("icons/dest4.jpg"));
            Image j2=i6.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k2=new ImageIcon(j2);
            l3=new JLabel(k2);
            l3.setBounds(0,300,1380,370);
            p1.add(l3);
            l3.setVisible(false);

            ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/dest5.jpg"));
            Image j3=i7.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k3=new ImageIcon(j3);
            l4=new JLabel(k3);
            l4.setBounds(0,300,1380,370);
            p1.add(l4);
            l4.setVisible(false);

            ImageIcon i8=new ImageIcon(ClassLoader.getSystemResource("icons/dest6.jpg"));
            Image j4=i8.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k4=new ImageIcon(j4);
            l5=new JLabel(k4);
            l5.setBounds(0,300,1380,370);
            p1.add(l5);
            l5.setVisible(false);

            ImageIcon i9=new ImageIcon(ClassLoader.getSystemResource("icons/dest7.jpeg"));
            Image j5=i9.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k5=new ImageIcon(j5);
            l6=new JLabel(k5);
            l6.setBounds(0,300,1380,370);
            p1.add(l6);
            l6.setVisible(false);


            ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/dest8.jpg"));
            Image j6=i10.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k6=new ImageIcon(j6);
            l7=new JLabel(k6);
            l7.setBounds(0,300,1380,370);
            p1.add(l7);
            l7.setVisible(false);

            ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/dest9.jpg"));
            Image j7=i11.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k7=new ImageIcon(j7);
            l8=new JLabel(k7);
            l8.setBounds(0,300,1380,370);
            p1.add(l8);
            l8.setVisible(false);

            ImageIcon l12=new ImageIcon(ClassLoader.getSystemResource("icons/dest10.jpg"));
            Image j8=l12.getImage().getScaledInstance(1380, 370, Image.SCALE_DEFAULT);
            ImageIcon k8=new ImageIcon(j8);
            l9=new JLabel(k8);
            l9.setBounds(0,300,1380,370);
            p1.add(l9);
            l9.setVisible(false);


            th.start();
            setVisible(true);

      }

      public static void main(String[] args) {
            new App();
      }
}