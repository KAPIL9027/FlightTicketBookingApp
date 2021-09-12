
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JourneyDetailsFrame extends JFrame {
    static JComboBox departFrom1;
    static JComboBox goingTo1;
    static JTextField departureDate1;
   static JTextField returnDate1;
    static JTextField travellers1;
    static JComboBox classes;
    static JComboBox trip;
    static JButton flights;


    public JourneyDetailsFrame()
    {
        setTitle("YOUR JOURNEY DETAILS");
        setLayout(null);
      setSize(1080,720);
      setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1080,80);
        JLabel bookYourTicket = new JLabel("Book Your Ticket! ");
        bookYourTicket.setForeground(Color.RED);
        bookYourTicket.setFont(new Font("TimesNewRoman",Font.BOLD,60));
        panel.add(bookYourTicket);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.RED);
        add(panel);
     String[] tripType = {"ONE WAY","ROUND TRIP"};
       trip = new JComboBox(tripType);
       trip.setBounds(350,150,350,40);
       trip.setFont(new Font("TimesNewRoman",Font.BOLD,30));
       add(trip);
        Font font = new Font("TimesNewRoman",Font.BOLD,27);
        JLabel departFrom = new JLabel("Depart From");
        departFrom.setFont(font);
        departFrom.setBounds(50,220,250,120);
        departFrom.setForeground(Color.GRAY);
        add(departFrom);
        JLabel goingTo = new JLabel("Going To");
        goingTo.setFont(font);
        goingTo.setForeground(Color.GRAY);
        goingTo.setBounds(800,220,250,120);
        add(goingTo);
        JLabel departureDate = new JLabel("Departure Date");
        departureDate.setFont(font);
        departureDate.setBounds(50,320,250,120);
        departureDate.setForeground(Color.GRAY);
        add(departureDate);
        JLabel returnDate =  new JLabel("Return Date");
        returnDate.setFont(font);
        returnDate.setBounds(800,320,250,120);
        returnDate.setForeground(Color.GRAY);
        add(returnDate);

        JLabel travellers = new JLabel("Traveller(s)");
        travellers.setBounds(50,450,250,40);
        travellers.setFont(font);
        travellers.setForeground(Color.GRAY);
        add(travellers);
        JLabel class1 = new JLabel("Class");
        class1.setBounds(50,540,600,40);
        class1.setFont(font);
        class1.setForeground(Color.GRAY);
        add(class1);
        String[] departureLocations = {"NEW DELHI","BANGALORE","MUMBAI","CHENNAI","HYDERABAD","GOA","KOLKATA","JAIPUR","PUNE","LUCKNOW"};
        String[] classString = {"ECONOMY","PREMIUM ECONOMY","BUSINESS"};
         departFrom1 =  new JComboBox(departureLocations);
         departFrom1.setBounds(50,310,250,40);
         departFrom1.setFont(new Font("TimesNewRoman",Font.BOLD,30));
         add(departFrom1);
        goingTo1 = new JComboBox(departureLocations);
        goingTo1.setBounds(800,310,250,40);
        goingTo1.setFont(new Font("TimesNewRoman",Font.BOLD,30));

        add( goingTo1);
        travellers1 = new JTextField();
        travellers1.setBounds(50,500,990,40);
        travellers1.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(travellers1);
        classes = new JComboBox(classString);
        classes.setBounds(50,580,990,40);
        classes.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        departureDate1 = new JTextField("Date Month Year");
        departureDate1.setBounds(50,410,250,40);
        departureDate1.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(departureDate1);
        returnDate1 = new JTextField("Date Month Year");
        returnDate1.setBounds(800,410,250,40);
        returnDate1.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        returnDate1.setVisible(true);
        add(returnDate1);

        add(classes);
            trip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(((String) trip.getSelectedItem()).equals("ONE WAY"))
                    {
                           returnDate1.setVisible(false);
                    }
                    else if(((String) trip.getSelectedItem()).equals("ROUND TRIP"))
                    {
                        returnDate1.setVisible(true);
                    }
                }
            });
            flights = new JButton("SEARCH FLIGHTS-->");
            flights.setBounds(905,630,150,37);
            flights.setBackground(Color.RED);
            flights.setForeground(Color.WHITE);
            add(flights);
            flights.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String travellers = travellers1.getText();
                    if(Integer.parseInt(travellers) > 4)
                    {
                        travellers1.setText("Cannot book ticket for more than 4 people !");
                        travellers1.setForeground(Color.RED);
                    }
                    else
                    {
                        new Flights();
                    }

                }
            });
    }

    public static void main(String[] args) {
        JourneyDetailsFrame jdf = new JourneyDetailsFrame();
    }
}
