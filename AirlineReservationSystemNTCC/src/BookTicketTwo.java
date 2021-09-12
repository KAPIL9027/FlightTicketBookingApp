import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTicketTwo extends JFrame {
    JLabel phno;
    JTextField phno_text;
    JLabel passportNumber;
    JTextField passport_number_text;
    JLabel address;
    JTextField address_text;
    JLabel nationality;
    JTextField nationality_text;
    JLabel name;
    static JTextField name_text;
    JLabel gender;
    JTextField gender_text;

    BookTicketTwo()
    {
        setTitle("CONFIRM YOUR PERSONAL DETAILS ");
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1080,1000);
        phno = new JLabel(" PHONE NO. : ");
        name = new JLabel(" NAME : ");
       passportNumber = new JLabel(" PASSPORT NO. : ");
        address = new JLabel(" ADDRESS : ");
        nationality = new JLabel(" NATIONALITY : ");
        gender = new JLabel(" GENDER : ");
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1080,80);
        JLabel bookYourTicket = new JLabel("YOUR PERSONAL DETAILS ");
        JCheckBox confirmation = new JCheckBox("I confirm that above given details are correct and If any of the above given details are found wrong, I agree to the decision of cancellation of my ticket. ");
        confirmation.setBackground(Color.white);
        confirmation.setFont(new Font("TimesNewRoman",Font.ITALIC,14));
        confirmation.setForeground(Color.RED);
        confirmation.setBounds(100,550,1000,40);
        add(confirmation);
        bookYourTicket.setForeground(Color.RED);
        bookYourTicket.setFont(new Font("TimesNewRoman",Font.BOLD,60));
        panel.add(bookYourTicket);
        panel.setBackground(Color.lightGray);
        panel.setForeground(Color.RED);
        add(panel);
        phno.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        phno.setBounds(100,350,400,300);
        add(phno);
        name.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        name.setBounds(100,0,400,300);
        add(name);
        passportNumber.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        passportNumber.setBounds(100,70,400,300);
        add(passportNumber);
        address.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        address.setBounds(100,140,400,300);
        add(address);
        nationality.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        nationality.setBounds(100,210,400,300);
        add( nationality);
        gender.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        gender.setBounds(100,280,400,300);
        add(gender);
        DatabaseConnection dbc = new DatabaseConnection();
        String name = "";
        String passport = "";
        String address = "";
        String nationality = "";
        String gender = "";
        String phone = "";


        try
        {
           String query = "select * from PassengerDetails where phno = '"+BookTicket.phno_text.getText()+"'";
            ResultSet rs = dbc.statement.executeQuery(query);
            rs.next();
             name = rs.getString("name");
             passport = rs.getString("passportNo");
             address = rs.getString("address");
             nationality = rs.getString("nationality");
             gender = rs.getString("gender");
             phone =  rs.getString("phno");

        }
        catch(SQLException es)
        {
            es.printStackTrace();
        }
        phno_text = new JTextField(phone);
        phno_text.setBounds(400,480,300,35);
        phno_text.setBackground(Color.white);
        phno_text.setForeground(Color.darkGray);
        phno_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(phno_text);
        name_text = new JTextField(name);
        name_text.setBounds(400,130,300,35);
        name_text.setBackground(Color.white);
        name_text.setForeground(Color.darkGray);
        name_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(name_text);
        passport_number_text = new JTextField( passport);
        passport_number_text.setBounds(400,200,300,35);
        passport_number_text.setBackground(Color.white);
        passport_number_text.setForeground(Color.darkGray);
        passport_number_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(passport_number_text);
        address_text = new JTextField( address);
        address_text.setBounds(400,270,300,35);
         address_text.setBackground(Color.white);
         address_text.setForeground(Color.darkGray);
        address_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(address_text);
        nationality_text = new JTextField(nationality);
        nationality_text.setBounds(400,340,300,35);
        nationality_text.setBackground(Color.white);
        nationality_text.setForeground(Color.darkGray);
        nationality_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add(nationality_text);
        gender_text = new JTextField(gender);
        gender_text.setBounds(400,410,300,35);
        gender_text.setBackground(Color.white);
        gender_text.setForeground(Color.darkGray);
        gender_text.setFont(new Font("Times New Roman",Font.ITALIC,24));
        add( gender_text);

        JButton next = new JButton("NEXT--->");
        next.setFont(new Font("Times New Roman",Font.PLAIN,24));
        next.setBackground(Color.RED);
        next.setForeground(Color.WHITE);
       add(next);
        next.setBounds(900,650,150,37);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(confirmation.isSelected())
                {
                   JOptionPane.showMessageDialog(null,"Your Personal Details are confirmed, You can proceed!");
                    new BookTicketThree();
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
        BookTicketTwo btt = new BookTicketTwo();
    }
}
