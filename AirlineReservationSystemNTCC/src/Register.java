import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JButton b1;
    JButton b2;
    JButton b3;
    Font font1;
    Font font2;


    public Register()
    {
        super("SIGN UP!!");
        setSize(610,486);
        getContentPane().setBackground(Color.WHITE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setVisible(true);
        setLayout(null);
        JLabel background = new JLabel(new ImageIcon(ClassLoader.getSystemResource("giphhy.gif")));
        background.setBounds(0,0,600,450);
        add(background);
        font1 = new Font("TimesNewRoman",Font.BOLD,50);
        font2 = new Font("TimesNewRoman",Font.BOLD,15);


        background.setLayout(null);

        l1 = new JLabel(" SIGN UP ");
        l2 = new JLabel(" USERNAME: ");
        l3 = new JLabel(" PASSWORD: ");
        l4 = new JLabel("CONFIRM PASSWORD:");
        l1.setFont(font1);
        l1.setBounds(200,150,300,40);
        l2.setFont(font2);
        l2.setBounds(100,200,150,30);
        l3.setFont(font2);
        l3.setBounds(100,250,150,30);
        l4.setFont(font2);
        l4.setBounds(100,300,270,30);
        l1.setForeground(Color.ORANGE);
        l2.setForeground(Color.black);
        l3.setForeground(Color.black);
        l4.setForeground(Color.black);

        t1 = new JTextField();
        t2 = new JPasswordField();
        t3 = new JPasswordField();
        b1 = new JButton(" RESET ");
        b2 = new JButton(" SUBMIT ");
        b3 = new JButton(" CANCEL ");

        t1.setBounds(270,200,200,24);
        t2.setBounds(270,250,200,24);
        t3.setBounds(270,300,200,24);
        b1.setBounds(130,350,100,27);
        b2.setBounds(280,350,100,27);
        b3.setBounds(430,350,100,27);
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
        background.add(l4);
        background.add(t3);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
        if(ae.getSource() == b2)
        {
            String userName = t1.getText();
            String password = t2.getText();
            String confirmPassword = t3.getText();
            if(!password.equals(confirmPassword))
            {
                JOptionPane.showMessageDialog(null,"Make sure password is same in both the fields.");
               return;
            }
            DatabaseConnection dc = new DatabaseConnection();
            try
            {
                String query = "insert into login values('"+userName+"','"+password+"')";
                dc.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Created an Account with Username:"+userName);
                setVisible(false);
                new LoginPage();
            }
            catch(SQLException e)
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
       Register register = new Register();
    }

}
