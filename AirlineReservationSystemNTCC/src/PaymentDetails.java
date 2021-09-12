import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentDetails extends JFrame {
    JLabel paymentDetails;
    JLabel cardNumber;
    JLabel cvv;
    JLabel name;
    JTextField cardNumberText;
    JTextField nameText;
    JButton submit;
    JLabel date;
    JLabel phno;
    JTextField phnoText;
    public PaymentDetails()
    {
        setTitle("ADD PAYMENT DETAILS");
        setLayout(null);
        setSize(1160,900);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("payment1.png"));
        JLabel image1 = new JLabel(image);
        image1.setBounds(470,50,600,600);
        add(image1);
        Font f1 = new Font("TimesNewRoman",Font.BOLD,17);
       paymentDetails = new JLabel("PAYMENT DETAILS");
        paymentDetails.setFont(new Font("TimesNewRoman",Font.BOLD,41));
        paymentDetails.setBounds(185,24,400,38);
        paymentDetails.setForeground(Color.RED);
        add(paymentDetails);

        name = new JLabel("NAME:");
        name.setBounds(30,124,150,27);
        name.setFont(f1);
        nameText = new JTextField();
        nameText.setBounds(200,124,150,27);
        add(name);
        add(nameText);
        phno = new JLabel("PHONE NO.:");
        phno.setBounds(30,224,150,27);
        phno.setFont(f1);
        phnoText = new JTextField("+91");
        phnoText.setBounds(200,224,150,27);
        add(phno);
        add(phnoText);
       cardNumber = new JLabel("CARD NUMBER:");
        cardNumber.setBounds(30,324,150,27);
       cardNumber.setFont(f1);
        cardNumberText = new JTextField();
        cardNumberText.setBounds(200,324,150,27);
        add( cardNumber);
        add( cardNumberText);
       cvv = new JLabel("CVV:");
       cvv.setBounds(30,424,150,27);
        cvv.setFont(f1);
        add( cvv);
        date = new JLabel("DATE OF EXPIRY:");
        date.setBounds(30,524,150,27);
       date.setFont(f1);
        add(date);
        JCalendar dateText = new JCalendar();
        dateText.setBounds(200,524,150,27);
        add(dateText);

       JTextField cvvText = new JTextField();
        cvvText.setBounds(200,424,150,27);
        add(cvvText);
        submit = new JButton("SUBMIT");
        submit.setBounds(200,650,150,30);
        add(submit);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection dbc = new DatabaseConnection();
                String name = nameText.getText();
                String phno = phnoText.getText();
                String cvv = cvvText.getText();
                Date date_expiry = dateText.getCalendar().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String date_of_expiry = dateFormat.format(date_expiry);
                System.out.println(date_of_expiry);
                String cardNumber = cardNumberText.getText();
                String query = "insert into paymentDetails values('"+name+"','"+phno+"','"+cardNumber+"','"+cvv+"','"+date_of_expiry+"')";
                try
                {
                    dbc.statement.executeUpdate(query);
                }
                catch(SQLException es)
                {
                    es.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Your Card: "+cardNumber+" is successfully added.");
            }
        });


    }
    public static void main(String[] args)
    {
        PaymentDetails pd = new PaymentDetails();
    }
}
