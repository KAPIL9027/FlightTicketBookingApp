import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTicketThree extends JFrame {

    JLabel phno;
    JTextField phno_text;
    JLabel card_number;
    JTextField card_number_text;
    JLabel cvv;
    JTextField cvv_text;
    JLabel name;
    JTextField name_text;
    JLabel date_of_expiry;
    JTextField date_of_expiry_text;
    BookTicketThree() {
        setTitle("CONFIRM YOUR PAYMENT DETAILS");
        setVisible(true);
        setLayout(null);
        setSize(1080, 1000);
        getContentPane().setBackground(Color.WHITE);
        name = new JLabel(" NAME : ");
        phno = new JLabel(" PHONE NO. : ");
        card_number = new JLabel(" CARD NO. : ");
        cvv = new JLabel(" CVV : ");
        date_of_expiry = new JLabel(" DATE OF EXPIRY : ");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1080, 80);
        JLabel bookYourTicket = new JLabel("YOUR PAYMENT DETAILS ");
        JCheckBox confirmation = new JCheckBox("I agree to use this card as my payment method and I allow to deduct necessary amount required to book the ticket from my account");
        confirmation.setFont(new Font("TimesNewRoman", Font.ITALIC, 14));
        confirmation.setBackground(Color.white);
        confirmation.setForeground(Color.RED);
        confirmation.setBounds(100, 550, 1000, 40);
        add(confirmation);
        bookYourTicket.setForeground(Color.RED);
        bookYourTicket.setFont(new Font("TimesNewRoman", Font.BOLD, 60));
        panel.add(bookYourTicket);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.RED);
        add(panel);

        name.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        name.setBounds(100, 0, 400, 300);
        add(name);
        phno.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        phno.setBounds(100, 70, 400, 300);
        add(phno);
        card_number.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        card_number.setBounds(100, 140, 400, 300);
        add(card_number);
        cvv.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        cvv.setBounds(100, 210, 400, 300);
        add(cvv);
        date_of_expiry.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        date_of_expiry.setBounds(100, 280, 400, 300);
        add(date_of_expiry);
        DatabaseConnection dbc = new DatabaseConnection();
        String name = "";
        String phno = "";
        String card_number = "";
        String cvv = "";
        String date = "";



        try
        {
            String query = "select * from paymentDetails where phno = '"+BookTicket.phno_text.getText()+"'";
            ResultSet rs = dbc.statement.executeQuery(query);
            rs.next();
            name = rs.getString("name");
            phno = rs.getString("phno");
            card_number = rs.getString("card_number");
            cvv = rs.getString("cvv");
            date = rs.getString("date");

        }
        catch(SQLException es)
        {
            es.printStackTrace();
        }
        name_text = new JTextField(name);
        name_text.setBounds(400, 130, 300, 35);
        name_text.setBackground(Color.white);
        name_text.setForeground(Color.darkGray);
        name_text.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        add(name_text);
        phno_text = new JTextField(phno);
        phno_text.setBounds(400, 200, 300, 35);
        phno_text.setBackground(Color.white);
        phno_text.setForeground(Color.darkGray);
        phno_text.setFont(new Font("Times New Roman",  Font.ITALIC, 24));
        add( phno_text);
        card_number_text = new JTextField(card_number);
        card_number_text.setBounds(400, 270, 300, 35);
        card_number_text.setBackground(Color.white);
        card_number_text.setForeground(Color.darkGray);
        card_number_text.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        add(card_number_text);
        cvv_text = new JTextField(cvv);
        cvv_text.setBounds(400, 340, 300, 35);
        cvv_text.setBackground(Color.white);
        cvv_text.setForeground(Color.darkGray);
        cvv_text.setFont(new Font("Times New Roman",  Font.ITALIC, 24));
        add(cvv_text);
        date_of_expiry_text = new JTextField(date);
        date_of_expiry_text.setBounds(400, 410, 300, 35);
        date_of_expiry_text.setBackground(Color.white);
        date_of_expiry_text.setForeground(Color.darkGray);
        date_of_expiry_text.setFont(new Font("Times New Roman",  Font.ITALIC, 24));
        add(date_of_expiry_text);

        JButton next = new JButton("NEXT--->");
        next.setBackground(Color.RED);
        next.setForeground(Color.WHITE);
       add(next);
        setLayout(null);
        next.setFont(new Font("Times New Roman",Font.PLAIN,24));
        next.setBounds(900, 650, 150, 37);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(confirmation.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Your payment details are confirmed. You can proceed!");
                    new JourneyDetailsFrame();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please tick the confirmation box!");
                }
            }
        });
    }

    public static void main(String[] args) {
        BookTicketThree bttt = new BookTicketThree();
    }
}
