import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTicketFirst extends JFrame {
    JLabel phno;
    static JTextField phno_text;
    JLabel pnr;
    static JTextField pnr_text;
    ViewTicketFirst()
    {
        setTitle("YOUR FLIGHT TICKET ");
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1080,1000);
        phno = new JLabel(" PHONE NUMBER: ");
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1080,80);
        JLabel bookYourTicket = new JLabel("FLIGHT TICKET! ");
        JLabel label = new JLabel("Enter your phone number through which you booked your ticket.");
        label.setFont(new Font("TimesNewRoman",Font.ITALIC,21));
        label.setForeground(Color.RED);
        label.setBounds(100,150,1000,800);
        add(label);
        bookYourTicket.setForeground(Color.RED);
        bookYourTicket.setFont(new Font("TimesNewRoman",Font.BOLD,60));
        panel.add(bookYourTicket);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.RED);
        add(panel);
        phno.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        phno.setBounds(100,200,400,300);
        add(phno);
        phno_text = new JTextField("+91");
        phno_text.setBounds(400,335,300,35);
        phno_text.setBackground(Color.white);
        phno_text.setForeground(Color.DARK_GRAY);
        phno_text.setFont(new Font("Times New Roman",Font.ITALIC,21));
        add(phno_text);
        pnr = new JLabel(" PNR NO.: ");
        pnr.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        pnr.setBounds(100,250,400,300);
        add(pnr);
        pnr_text = new JTextField();
        pnr_text.setBounds(400,385,300,35);
        pnr_text.setBackground(Color.white);
        pnr_text.setForeground(Color.DARK_GRAY);
        pnr_text.setFont(new Font("Times New Roman",Font.ITALIC,21));
        add(pnr_text);



        JButton ticket = new JButton("TICKET");
        ticket.setBackground(Color.RED);
        ticket.setForeground(Color.WHITE);
      add(ticket);
        setLayout(null);
        ticket.setBounds(900,615,80,37);
        ticket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phnoText = phno_text.getText();
                DatabaseConnection dbc = new DatabaseConnection();
                try
                {
                    ResultSet rs = dbc.statement.executeQuery("select * from reservation where phno = '"+phnoText+"' and pnr='"+pnr_text.getText()+"'");
                    if(rs.next())
                    {
                        ticket.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null,"Your ticket is found, You can proceed!");
                       new ViewTicket();
                       setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"We did not find any ticket related to this phone number and pnr number. Please try again.");
                    }
                }
                catch(SQLException es)
                {
                    es.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        ViewTicketFirst vtf = new ViewTicketFirst();
    }
}
