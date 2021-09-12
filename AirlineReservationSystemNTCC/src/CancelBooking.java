import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelBooking extends JFrame {
    JLabel cancellation;
    JLabel pnr;
    JLabel flightCode;
    JLabel name;
    JTextField pnrText;
    JTextField flightCodeText;
    JTextField nameText;
    JButton submit;
    JLabel phno;
    JTextField phnoText;

    public CancelBooking()
    {
        setTitle("CANCEL YOUR BOOKING (NO REFUNDS)");
        setLayout(null);
        setSize(1100,900);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("cancel.png"));
        JLabel image1 = new JLabel(image);
        image1.setBounds(470,100,500,500);
        add(image1);
        Font f1 = new Font("TimesNewRoman",Font.BOLD,17);
         cancellation = new JLabel("CANCELLATION");
        cancellation.setFont(new Font("TimesNewRoman",Font.BOLD,41));
        cancellation.setBounds(185,24,400,38);
        cancellation.setForeground(Color.RED);
        add(cancellation);
        name = new JLabel("NAME:");
        name.setBounds(80,224,150,27);
        name.setFont(f1);
        nameText = new JTextField();
        nameText.setBounds(200,224,150,27);
        add(name);
        add(nameText);
        flightCode = new JLabel("FLIGHT NAME:");
        flightCode.setBounds(80,324,150,27);
        flightCode.setFont(f1);
        flightCodeText = new JTextField();
        flightCodeText.setBounds(200,324,150,27);
        add(flightCode);
        add(flightCodeText);
        pnr = new JLabel("PNR NO. :");
        pnr.setBounds(80,424,150,27);
        pnr.setFont(f1);
        add(pnr);
       phno = new JLabel("PHONE NO. :");
        phno.setBounds(80,524,150,27);
        phno.setFont(f1);
        add(phno);
        phnoText = new JTextField("+91");
        phnoText.setBounds(200,524,150,27);
        add( phnoText);
        pnrText = new JTextField();
        pnrText.setBounds(200,424,150,27);
        add(pnrText);
        submit = new JButton("SUBMIT");
        submit.setBounds(200,650,150,30);
        add(submit);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection dc = new DatabaseConnection();
                String name = nameText.getText();
                String flight_code = flightCodeText.getText();
                String pnr_id = pnrText.getText();
                String phno = phnoText.getText();
                String query = "insert into cancelBooking values('"+name+"','"+flight_code+"','"+pnr_id+"')";
                try {
                    String q = "select bookingid from reservation where pnr = '"+pnr_id+"'";
                    ResultSet rs = dc.statement.executeQuery(q);
                    rs.next();
                    String bookingId = rs.getString("bookingid");
                    dc.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Cancel ticket with pnr number: "+
                            pnr_id+" and booking reference id: "+bookingId+" ?");
                    String q1 = "delete from reservation where pnr = '"+pnr_id+"'"+"and name = '"+name+"' and airline ='"+flight_code+"' and phno = '"+phno+"'";
                    dc.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Your booking was successfully cancelled.");
                    setVisible(false);
                }
                catch(SQLException es)
                {
                    es.printStackTrace();
                    JOptionPane.showMessageDialog(null,"No Booking found!!!");
                }
            }
        });


    }
    public static void main(String[] args)
    {
        CancelBooking cancelBooking = new CancelBooking();
    }
}
