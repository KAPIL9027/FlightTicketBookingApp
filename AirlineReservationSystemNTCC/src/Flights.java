import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Flights extends JFrame {
    String query;
   static JTextField flightText;
   static JTextField airportSText;
    static JTextField airportDText;
    static JTextField arrivalText;
    static JTextField departText;
    static JTextField durationText;
    static JTextField priceText;

    Flights() {
        setTitle("FLIGHTS: "+(String) JourneyDetailsFrame.departFrom1.getSelectedItem()
                 +" -----> "+ (String) JourneyDetailsFrame.goingTo1.getSelectedItem());
        setLayout(null);
        setSize(2180, 1080);
        setVisible(true);
        Font font = new Font("TimesNewRoman", Font.BOLD, 21);
        JLabel flight = new JLabel("FLIGHT");
        flight.setFont(font);
        flight.setForeground(Color.white);
        JLabel depart = new JLabel("DEPART");
        depart.setFont(font);
        depart.setForeground(Color.white);
        JLabel arrive = new JLabel("ARRIVE");
        arrive.setFont(font);
        arrive.setForeground(Color.white);
        JLabel duration = new JLabel("DURATION");
        duration.setFont(font);
        duration.setForeground(Color.white);
        JLabel airportArrive = new JLabel("AIRPORT(Dest.)");
        airportArrive.setForeground(Color.white);
        airportArrive.setFont(font);
        JLabel airportDepart = new JLabel("AIRPORT(Source)");
        airportDepart.setForeground(Color.white);
        airportDepart.setFont(font);
        JLabel price = new JLabel("PRICE");
        price.setForeground(Color.white);
        price.setFont(font);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 80, 47));
        panel.setBackground(Color.RED);
        panel.setForeground(Color.WHITE);
        panel.add(flight);
        panel.add(depart);
        panel.add(arrive);
        panel.add(duration);
        panel.add(airportDepart);
        panel.add(airportArrive);
        panel.add(price);
        panel.setBounds(0, 0, 2180, 90);
        add(panel);
        JTable table = new JTable();
        table.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        table.setAutoCreateColumnsFromModel(true);

        table.setBounds(0, 100, 1380, 200);
        table.setBackground(Color.WHITE);
        DatabaseConnection dc = new DatabaseConnection();
        {
            String tripType = (String) JourneyDetailsFrame.trip.getSelectedItem();
            if (tripType.equals("ONE WAY")) {
                String departDate = JourneyDetailsFrame.departureDate1.getText();
                query = "select Flight,Depart,Arrive,Duration,Source,Destination,Price from Flights where TripType = '"
                        + tripType + "' and DepartDate = '" + departDate + "' and Class = '" +
                        (String) JourneyDetailsFrame.classes.getSelectedItem() + "' and SL ='"+
                        (String) JourneyDetailsFrame.departFrom1.getSelectedItem()+"' and DL ='"+
                        (String) JourneyDetailsFrame.goingTo1.getSelectedItem()+"'" ;
            } else {
                String departDate = JourneyDetailsFrame.departureDate1.getText();

                String returnDate = JourneyDetailsFrame.returnDate1.getText();

                query = "select Flight,Depart,Arrive,Duration,Source,Destination,Price from Flights where TripType = '" +
                        tripType + "'and DepartDate = '" + departDate + "' and ReturnDate = '" +
                        returnDate + "' and Class = '" + (String) JourneyDetailsFrame.classes.getSelectedItem() + "'and SL ='"+
                        (String) JourneyDetailsFrame.departFrom1.getSelectedItem()+"' and DL ='"+
                        (String) JourneyDetailsFrame.goingTo1.getSelectedItem()+"'" ;
            }
        }
        if (query != null)
            try {
                ResultSet rs = dc.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        add(table);
        Font font1 = new Font("TimesNewRoman", Font.BOLD, 31);
        Font font2 = new Font("TimesNewRoman", Font.BOLD, 24);
        JLabel flight1 = new JLabel("FLIGHT");
        flight1.setBounds(50, 310, 200, 40);
        flight1.setFont(font1);
        flight1.setForeground(Color.GRAY);
        add(flight1);
        flightText = new JTextField();
        flightText.setBounds(350, 310, 300, 37);
        flightText.setFont(font2);
        flightText.setForeground(Color.BLACK);
        add(flightText);
        JLabel depart1 = new JLabel("DEPART");
        depart1.setBounds(750, 310, 200, 40);
        depart1.setFont(font1);
        depart1.setForeground(Color.GRAY);
        add(depart1);
        departText = new JTextField();
        departText.setBounds(1050, 310, 300, 37);
        departText.setFont(font2);
        departText.setForeground(Color.BLACK);
        add(departText);

        JLabel arrive1 = new JLabel("ARRIVE");
        arrive1.setBounds(750, 510, 200, 40);
        arrive1.setFont(font1);
        arrive1.setForeground(Color.GRAY);
        add(arrive1);
        arrivalText = new JTextField();
        arrivalText.setBounds(1050, 510, 300, 37);
        arrivalText.setFont(font2);
        arrivalText.setForeground(Color.BLACK);
        add(arrivalText);
        JLabel duration1 = new JLabel("DURATION");
        duration1.setBounds(750, 410, 200, 40);
        duration1.setFont(font1);
        duration1.setForeground(Color.GRAY);
        add(duration1);
        durationText = new JTextField();
        durationText.setBounds(1050, 410, 300, 37);
        durationText.setFont(font2);
        durationText.setForeground(Color.BLACK);
        add(durationText);

        JLabel airportArrive1 = new JLabel("AIRPORT(D)");
        airportArrive1.setBounds(50, 410, 200, 40);
        airportArrive1.setFont(font1);
        airportArrive1.setForeground(Color.GRAY);
        add(airportArrive1);
        airportDText = new JTextField();
        airportDText.setBounds(350, 410, 300, 37);
        airportDText.setFont(font2);
        airportDText.setForeground(Color.BLACK);
        add(airportDText);
        JLabel airportDepart1 = new JLabel("AIRPORT(S)");
        airportDepart1.setBounds(50, 510, 200, 40);
        airportDepart1.setFont(font1);
        airportDepart1.setForeground(Color.GRAY);
        add(airportDepart1);
        airportSText = new JTextField();
        airportSText.setBounds(350, 510, 300, 37);
        airportSText.setFont(font2);
        airportSText.setForeground(Color.BLACK);
        add(airportSText);

        JLabel price1 = new JLabel("PRICE");
        price1.setBounds(50, 610, 200, 40);
        price1.setFont(font1);
        price1.setForeground(Color.GRAY);
        add(price1);
        priceText = new JTextField();
        priceText.setBounds(350, 610, 300, 37);
        priceText.setFont(font2);
        priceText.setForeground(Color.BLACK);
        add(priceText);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              int rowSelected = table.getSelectedRow();
              String flightValue = table.getValueAt(rowSelected,0).toString();
                String departValue = table.getValueAt(rowSelected,1).toString();
                String arriveValue = table.getValueAt(rowSelected,2).toString();
                String durationValue = table.getValueAt(rowSelected,3).toString();
                String airportSValue = table.getValueAt(rowSelected,4).toString();
                String airportDValue = table.getValueAt(rowSelected,5).toString();
                String priceValue = table.getValueAt(rowSelected,6).toString();
                String[] array = priceValue.split(" ");

                flightText.setText(flightValue);
                departText.setText(departValue);
                arrivalText.setText(arriveValue);
                durationText.setText(durationValue);
                airportSText.setText(airportSValue);
                airportDText.setText(airportDValue);
                int travellers = Integer.parseInt(JourneyDetailsFrame.travellers1.getText());
                int price = Integer.parseInt(array[0]);
                priceText.setText("₹"+price*travellers);
            }
        });
        JButton bookTicket = new JButton("BOOK TICKET--->");
        bookTicket.setForeground(Color.white);
        bookTicket.setBackground(Color.RED);
        bookTicket.setBounds(1020,640,250,37);
        bookTicket.setFont(new Font("TimesNewRoman",Font.BOLD,24));
        add(bookTicket);
        bookTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(JourneyDetailsFrame.travellers1.getText()) > 1)
                {
                     new otherTravellersDetails();
                }
                else
                {
                     new Ticket();
                }
                setVisible(false);
            }
        });


    }
    public static void main(String[] args) {
        Flights fg = new Flights();
    }
}
