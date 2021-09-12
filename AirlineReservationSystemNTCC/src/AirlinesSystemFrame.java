import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirlinesSystemFrame extends JFrame {
    JMenuBar menuBar;
    JMenu m1;
    JMenu m2;

    public AirlinesSystemFrame()
    {
        super("Airline Reservation System");
       setLocation(300, 40);
        JOptionPane.showMessageDialog(this,"Welcome to Airlines Ticket Booking.");
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(ClassLoader.getSystemResource("aeroo.gif"))));
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        menuBar = new JMenuBar();
        m1 = new JMenu("FLIGHT");
        m1.setFont(new Font("TimesNewRoman",Font.BOLD,18));
        m1.setForeground(Color.WHITE);
        m1.setBounds(10,0,100,24);
        m2 = new JMenu("TICKET");
        m2.setFont(new Font("TimesNewRoman",Font.BOLD,18));
        m2.setBounds(30,0,100,24);
        m2.setForeground(Color.WHITE);

        JMenu m3 = new JMenu("HELP");
        m3.setFont(new Font("TimesNewRoman",Font.BOLD,18));
        m3.setForeground(Color.WHITE);
        m3.setBounds(50,0,100,24);
        JMenu m4 = new JMenu(""+LoginPage.t1.getText().toUpperCase());
        m4.setFont(new Font("TimesNewRoman",Font.BOLD,18));
        m4.setForeground(Color.WHITE);
        m4.setBounds(900,0,100,24);
        menuBar.setBorderPainted(true);
        menuBar.setBackground(Color.RED
        );
        menuBar.setForeground(Color.WHITE);
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);
        menuBar.add(m4);

       setJMenuBar(menuBar);
       JMenuItem flightInformation = new JMenuItem("Flight Information");
        JMenuItem addCustomerDetails = new JMenuItem("Add Customer Details");
        JMenuItem paymentDetails = new JMenuItem("Payment Details");
        JMenuItem cancelBooking = new JMenuItem("Cancel Booking");
        JMenuItem bookTicket = new JMenuItem("Book Ticket");
        JMenuItem viewTicket = new JMenuItem("View Ticket");
        JMenuItem userGuide = new JMenuItem("USER GUIDE");
        JMenuItem logout = new JMenuItem("LOGOUT");
        m1.add(flightInformation);
        m1.add(addCustomerDetails);
        m1.add(paymentDetails);
        m1.add(cancelBooking);
        m2.add(bookTicket);
        m2.add(viewTicket);
        m3.add(userGuide);
        m4.add(logout);
        flightInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightInformation();

            }
        });
       addCustomerDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomersDetails();

            }
        });
        paymentDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new PaymentDetails();
            }
        });
       cancelBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new CancelBooking();
            }
        });
       bookTicket.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              new BookTicket();
           }
       });
       viewTicket.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                new ViewTicketFirst();
           }
       });
       userGuide.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                new UserGuide();
           }
       });
       logout.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               new LoginPage();
           }
       });
    }
    public static void main(String[] args)
    {
        AirlinesSystemFrame afs = new AirlinesSystemFrame();
    }

}
