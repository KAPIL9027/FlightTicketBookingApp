
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
   static JTextField t1;
    JTextField t2;
    JButton b1;
    JButton b2;
    JButton b3;
    Font font1;
    Font font2;


    public LoginPage()
    {
        super("LOGIN ");
        setSize(610,486);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("giphhy.gif")));
        background.setBounds(0,0,600,450);
        add(background);
        font1 = new Font("TimesNewRoman",Font.BOLD,50);
        font2 = new Font("TimesNewRoman",Font.BOLD,15);


        background.setLayout(null);
        l1 = new JLabel(" LOGIN ");
        l2 = new JLabel(" USERNAME: ");
        l3 = new JLabel(" PASSWORD: ");
        l1.setFont(font1);
        l1.setBounds(200,150,200,40);
        l2.setFont(font2);
        l2.setBounds(100,200,150,30);
        l3.setFont(font2);
        l3.setBounds(100,250,150,30);
        l1.setForeground(Color.ORANGE);
        l2.setForeground(Color.black);
        l3.setForeground(Color.black);
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton(" RESET ");
        b2 = new JButton(" SUBMIT ");
        b3 = new JButton(" CANCEL ");

      t1.setBounds(200,200,200,24);
      t2.setBounds(200,250,200,24);
      b1.setBounds(130,300,100,27);
        b2.setBounds(240,300,100,27);
        b3.setBounds(350,300,100,27);
        b1.setBackground(Color.ORANGE);
        b2.setBackground(Color.ORANGE);
        b3.setBackground(Color.ORANGE);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(b1);
        background.add(b2);
        background.add(b3);
        background.add(t1);
        background.add(t2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        JLabel register = new JLabel("Don't have an account?Click here to sign up!");
        register.setBounds(40,220,540,280);
        register.setFont(new Font("TimesNewRoman",Font.BOLD,23));
        register.setForeground(Color.BLUE);
        background.add(register);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Register();
                setVisible(false);
            }
        });

    }
    public void actionPerformed(ActionEvent ae)
    {
           if(ae.getSource() == b1)
           {
               t1.setText("");
               t2.setText("");
           }
            if(ae.getSource() == b2)
           {
               String username = t1.getText();
               String password = t2.getText();

               DatabaseConnection dc = new DatabaseConnection();
               try {
                   ResultSet rs = dc.statement.executeQuery("select * from login where Username = '" + username + "' and Password = '" + password + "'");
                   if(rs.next())
                   {
                        new AirlinesSystemFrame();
                       setVisible(false);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Wrong Username or Password. Please try again"
                               );
                   }
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }

           }
        if(ae.getSource() == b3)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }



}
