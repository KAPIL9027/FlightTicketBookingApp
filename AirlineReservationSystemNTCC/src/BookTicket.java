import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookTicket extends JFrame {

    JLabel phno;
    static JTextField phno_text;
    BookTicket()
    {
        setTitle("BOOK YOUR TICKET");
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1080,1000);
        phno = new JLabel(" PHONE NUMBER: ");
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1080,80);
        JLabel bookYourTicket = new JLabel("Book Your Ticket! ");
        JLabel label = new JLabel("This phone number will be used to add your details that you added in the previous steps\n, So please write\n your registered phone number only.");
        label.setFont(new Font("TimesNewRoman",Font.ITALIC,14));
        label.setForeground(Color.RED);
        label.setBounds(100,150,1000,800);
        add(label);
        bookYourTicket.setForeground(Color.RED);
        bookYourTicket.setFont(new Font("TimesNewRoman",Font.BOLD,60));
        panel.add(bookYourTicket);
        panel.setBackground(Color.lightGray);
        panel.setForeground(Color.RED);
        add(panel);
        phno.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        phno.setBounds(100,200,400,300);
        add(phno);
        phno_text = new JTextField("+91");
        phno_text.setBounds(400,335,300,35);
        phno_text.setBackground(Color.white);
        phno_text.setForeground(Color.darkGray);
        phno_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(phno_text);

        JButton next = new JButton("NEXT--->");
        next.setFont(new Font("Times New Roman",Font.BOLD,24));
        next.setBackground(Color.RED);
        next.setForeground(Color.WHITE);
      add(next);

        next.setBounds(900,650,150,37);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phnoText = phno_text.getText();
                DatabaseConnection dbc = new DatabaseConnection();
                try
                {
                    ResultSet rs = dbc.statement.executeQuery("select * from PassengerDetails where phno = '"+phnoText+"'");
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"Your phone number is verified, You can proceed!");
                        new BookTicketTwo();
                        setVisible(false);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"We did not find this phone number. Please try again or Register your phone number if not yet!");
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
        BookTicket bt = new BookTicket();
    }
}
