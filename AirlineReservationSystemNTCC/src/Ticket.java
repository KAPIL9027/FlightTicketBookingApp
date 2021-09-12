import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ticket extends JFrame {
    static String ticketNumber;
    JLabel ticketNumber123;
    JLabel ticketNumber12;
    Ticket()
    {
        setTitle("YOUR E-TICKET");
        setSize(2180,1080);
        setVisible(true);
        setLayout(null);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0,0,2180,100);
        add(panel);
        JLabel label = new JLabel("E-TICKET");
        label.setFont(new Font("TimesNewRoman",Font.BOLD,60));
        label.setForeground(Color.RED);
        panel.add(label);
        JLabel flight = new JLabel("FLIGHT");
        JLabel eTicket = new JLabel("E-TICKET");
        JLabel referenceId = new JLabel("REFERENCE ID ");
        String bookingId = ""+numbGen();
        JLabel id = new JLabel(bookingId);
        flight.setBounds(50,140,200,37);
        flight.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(flight);
        eTicket.setBounds(300,140,200,37);
        eTicket.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(eTicket);
        referenceId.setBounds(550,140,450,37);
        referenceId.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(referenceId);
        id.setBounds(950,140,450,37);
        id.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        id.setForeground(Color.RED);
        add(id);
        JPanel panel2 = new JPanel();
     //   JScrollPane scrollPane = new JScrollPane(panel2);
        panel2.setBounds(0,220,2180,210);
        panel2.setBackground(Color.white);
        panel2.setLayout(null);
        panel2.setForeground(Color.black);
        add(panel2);
        JLabel passDetails = new JLabel("PASSENGER(S) DETAILS");
        passDetails.setBounds(0,0,600,37);
        passDetails.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        panel2.add(passDetails);
        JLabel border = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        border.setBounds(0,50,2180,7);
        border.setForeground(Color.lightGray);
        panel2.add(border);
        JLabel name = new JLabel("NAME");
        name.setBounds(0,60,200,37);
        name.setForeground(Color.black);
        name.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(name);
        JLabel destination = new JLabel("DESTINATION");
        destination.setBounds(300,60,200,37);
        destination.setForeground(Color.black);
        destination.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(destination);
        JLabel meals = new JLabel("MEALS");
        meals.setBounds(520,60,200,37);
        meals.setForeground(Color.black);
        meals.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(meals);
        JLabel baggage = new JLabel("BAGGAGE");
        baggage.setBounds(700,60,200,37);
        baggage.setForeground(Color.black);
        baggage.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(baggage);
        JLabel seatNo = new JLabel("SEAT NO.");
        seatNo.setBounds(900,60,200,37);
        seatNo.setForeground(Color.black);
        seatNo.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(seatNo);
        JLabel ticketNo = new JLabel("TICKET NO.");
        ticketNo.setBounds(1100,60,200,37);
        ticketNo.setForeground(Color.black);
        ticketNo.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel2.add(ticketNo);
        JLabel basic = new JLabel("NA");
        basic.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        basic.setForeground(Color.black);
        basic.setBounds(520,90,200,37);
        panel2.add(basic);
        JLabel baggage1 = new JLabel("15Kgs(Free)");
        baggage1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        baggage1.setForeground(Color.black);
        baggage1.setBounds(700,90,200,37);
        panel2.add(baggage1);
        JLabel seatNo1 = new JLabel("NA");
        seatNo1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        seatNo1.setForeground(Color.black);
        seatNo1.setBounds(900,90,200,37);
        panel2.add(seatNo1);
        JLabel name1 = new JLabel(BookTicketTwo.name_text.getText());
        name1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        name1.setForeground(Color.black);
        name1.setBounds(0,90,200,37);
        panel2.add(name1);
        String s1 = (String) JourneyDetailsFrame.departFrom1.getSelectedItem();
        String sCode = s1.substring(0,3);
        String s2 = (String) JourneyDetailsFrame.goingTo1.getSelectedItem();
        String dCode = s2.substring(0,3);
        String code = sCode + "-"+dCode;
        JLabel destination1 = new JLabel(code);
        destination1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        destination1.setForeground(Color.black);
        destination1.setBounds(300,90,200,37);
        panel2.add(destination1);
        String firstTwo = BookTicketTwo.name_text.getText().toUpperCase();
        String l3Digits = BookTicket.phno_text.getText();
        ticketNumber = firstTwo.substring(0,2)+"0"+l3Digits.substring(10,13);
        JLabel ticketNumber1 = new JLabel(ticketNumber);
        ticketNumber1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
        ticketNumber1.setForeground(Color.black);
        ticketNumber1.setBounds(1100,90,200,37);
        panel2.add(ticketNumber1);
        if(Integer.parseInt(JourneyDetailsFrame.travellers1.getText()) == 2)
        {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520,120,200,37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700,120,200,37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900,120,200,37);
            panel2.add(seatNo12);
            JLabel name12 = new JLabel(otherTravellersDetails.nameText.getText());
            name12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name12.setForeground(Color.black);
            name12.setBounds(0,120,200,37);
            panel2.add(name12);
            JLabel destination12 = new JLabel(code);
            destination12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination12.setForeground(Color.black);
            destination12.setBounds(300,120,200,37);
            panel2.add(destination12);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100,120,200,37);
            panel2.add(ticketNumber12);
        }
        if(Integer.parseInt(JourneyDetailsFrame.travellers1.getText()) == 3)
        {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520,120,200,37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700,120,200,37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900,120,200,37);
            panel2.add(seatNo12);
            JLabel name12 = new JLabel(otherTravellersDetails.nameText.getText());
            name12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name12.setForeground(Color.black);
            name12.setBounds(0,120,200,37);
            panel2.add(name12);
            JLabel destination12 = new JLabel(code);
            destination12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination12.setForeground(Color.black);
            destination12.setBounds(300,120,200,37);
            panel2.add(destination12);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100,120,200,37);
            panel2.add(ticketNumber12);

            JLabel basic12 = new JLabel("NA");
            basic12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic12.setForeground(Color.black);
            basic12.setBounds(520,150,200,37);
            panel2.add(basic12);
            JLabel baggage123 = new JLabel("15Kgs(Free)");
            baggage123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage123.setForeground(Color.black);
            baggage123.setBounds(700,150,200,37);
            panel2.add(baggage123);
            JLabel seatNo123 = new JLabel("NA");
            seatNo123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo123.setForeground(Color.black);
            seatNo123.setBounds(900,150,200,37);
            panel2.add(seatNo123);
            JLabel name123 = new JLabel(otherTravellersDetails.nameText1.getText());
            name123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name123.setForeground(Color.black);
            name123.setBounds(0,150,200,37);
            panel2.add(name123);
            JLabel destination123 = new JLabel(code);
            destination123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination123.setForeground(Color.black);
            destination123.setBounds(300,150,200,37);
            panel2.add(destination123);
            JLabel ticketNumber123 = new JLabel(ticketNumber);
            ticketNumber123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1100,150,200,37);
            panel2.add(ticketNumber123);

        }
        if(Integer.parseInt(JourneyDetailsFrame.travellers1.getText()) == 4)
        {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520,120,200,37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700,120,200,37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900,120,200,37);
            panel2.add(seatNo12);
            JLabel name12 = new JLabel(otherTravellersDetails.nameText.getText());
            name12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name12.setForeground(Color.black);
            name12.setBounds(0,120,200,37);
            panel2.add(name12);
            JLabel destination12 = new JLabel(code);
            destination12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination12.setForeground(Color.black);
            destination12.setBounds(300,120,200,37);
            panel2.add(destination12);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100,120,200,37);
            panel2.add(ticketNumber12);

            JLabel basic12 = new JLabel("NA");
            basic12.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic12.setForeground(Color.black);
            basic12.setBounds(520,150,200,37);
            panel2.add(basic12);
            JLabel baggage123 = new JLabel("15Kgs(Free)");
            baggage123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage123.setForeground(Color.black);
            baggage123.setBounds(700,150,200,37);
            panel2.add(baggage123);
            JLabel seatNo123 = new JLabel("NA");
            seatNo123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo123.setForeground(Color.black);
            seatNo123.setBounds(900,150,200,37);
            panel2.add(seatNo123);
            JLabel name123 = new JLabel(otherTravellersDetails.nameText1.getText());
            name123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name123.setForeground(Color.black);
            name123.setBounds(0,150,200,37);
            panel2.add(name123);
            JLabel destination123 = new JLabel(code);
            destination123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination123.setForeground(Color.black);
            destination123.setBounds(300,150,200,37);
            panel2.add(destination123);
            JLabel ticketNumber123 = new JLabel(ticketNumber);
            ticketNumber123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1100,150,200,37);
            panel2.add(ticketNumber123);

            JLabel basic123 = new JLabel("NA");
            basic123.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            basic123.setForeground(Color.black);
            basic123.setBounds(520,180,200,37);
            panel2.add(basic123);
            JLabel baggage1234 = new JLabel("15Kgs(Free)");
            baggage1234.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            baggage1234.setForeground(Color.black);
            baggage1234.setBounds(700,180,200,37);
            panel2.add(baggage1234);
            JLabel seatNo1234 = new JLabel("NA");
            seatNo1234.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            seatNo1234.setForeground(Color.black);
            seatNo1234.setBounds(900,180,200,37);
            panel2.add(seatNo1234);
            JLabel name1234 = new JLabel(otherTravellersDetails.nameText2.getText());
            name1234.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            name1234.setForeground(Color.black);
            name1234.setBounds(0,180,200,37);
            panel2.add(name1234);
            JLabel destination1234 = new JLabel(code);
            destination1234.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            destination1234.setForeground(Color.black);
            destination1234.setBounds(300,180,200,37);
            panel2.add(destination1234);
            JLabel ticketNumber1234 = new JLabel(ticketNumber);
            ticketNumber1234.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            ticketNumber1234.setForeground(Color.black);
            ticketNumber1234.setBounds(1100,180,200,37);
            panel2.add(ticketNumber1234);
        }
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,450,2180,100);
        panel3.setBackground(Color.white);
        panel3.setLayout(null);
        panel3.setForeground(Color.black);
        add(panel3);

        JLabel airLine = new JLabel("AIRLINE");
        airLine.setBounds(0,10,200,37);
        airLine.setForeground(Color.black);
        airLine.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel3.add(airLine);
        JLabel departure = new JLabel("DEPARTURE");
        departure.setBounds(300,10,200,37);
        departure.setForeground(Color.black);
        departure.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel3.add(departure);
        JLabel arrival = new JLabel("ARRIVAL");
        arrival.setBounds(720,10,200,37);
        arrival.setForeground(Color.black);
        arrival.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel3.add(arrival);
        JLabel duration = new JLabel("DURATION");
        duration.setBounds(1120,10,200,37);
        duration.setForeground(Color.black);
        duration.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel3.add(duration);
        JLabel pnr = new JLabel("PNR");
        pnr.setBounds(1300,10,200,37);
        pnr.setForeground(Color.black);
        pnr.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel3.add(pnr);
        String pnrNumber = "J"+pnrNumber();
        if(((String) JourneyDetailsFrame.trip.getSelectedItem()).equals("ONE WAY"))
        {
            JLabel airlineText = new JLabel(Flights.flightText.getText());
            airlineText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            airlineText.setForeground(Color.black);
            airlineText.setBounds(0,40,200,37);
            panel3.add(airlineText);
            String s12 =  Flights.airportSText.getText()+","+JourneyDetailsFrame.departureDate1.getText()+","+
                          Flights.departText.getText();
              String s13 = Flights.airportDText.getText()+","+JourneyDetailsFrame.departureDate1.getText()+","+
                          Flights.arrivalText.getText();
            JLabel departureText = new JLabel(s12);
            departureText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            departureText.setForeground(Color.black);
            departureText.setBounds(300,40,500,37);
            panel3.add(departureText);
            JLabel arrivalText = new JLabel(s13);
            arrivalText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            arrivalText.setForeground(Color.black);
            arrivalText.setBounds(720,40,500,37);
            panel3.add(arrivalText);
            JLabel durationText = new JLabel(Flights.durationText.getText());
            durationText.setBounds(1120,40,200,37);
            durationText.setForeground(Color.black);
            durationText.setFont(new Font("TimesNewRoman",Font.PLAIN,19));
            panel3.add(durationText);

            ticketNumber12 = new JLabel(pnrNumber);
            ticketNumber12.setVisible(false);
            ticketNumber12.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1300,40,200,37);
            panel3.add(ticketNumber12);
        }
       if(((String) JourneyDetailsFrame.trip.getSelectedItem()).equals("ROUND TRIP"))
        {
            JLabel airlineText = new JLabel(Flights.flightText.getText());
            airlineText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            airlineText.setForeground(Color.black);
            airlineText.setBounds(0,40,200,37);
            panel3.add(airlineText);
            String s12 =  Flights.airportSText.getText()+","+JourneyDetailsFrame.departureDate1.getText()+","+
                    Flights.departText.getText();
            String s13 = Flights.airportDText.getText()+","+JourneyDetailsFrame.departureDate1.getText()+","+
                    Flights.arrivalText.getText();
            JLabel departureText = new JLabel(s12);
            departureText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            departureText.setForeground(Color.black);
            departureText.setBounds(300,40,500,37);
            panel3.add(departureText);
            JLabel arrivalText = new JLabel(s13);
            arrivalText.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            arrivalText.setForeground(Color.black);
            arrivalText.setBounds(720,40,500,37);
            panel3.add(arrivalText);
            JLabel durationText = new JLabel(Flights.durationText.getText());
            durationText.setBounds(1120,40,200,37);

            durationText.setFont(new Font("TimesNewRoman",Font.PLAIN,19));
            panel3.add(durationText);

            ticketNumber12 = new JLabel(pnrNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1300,40,200,37);
            ticketNumber12.setVisible(false);
            panel3.add(ticketNumber12);

            JLabel airlineText1 = new JLabel(Flights.flightText.getText());
            airlineText1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            airlineText1.setForeground(Color.black);
            airlineText1.setBounds(0,60,200,37);
            panel3.add(airlineText1);
            String s122 =  Flights.airportSText.getText()+","+JourneyDetailsFrame.returnDate1.getText()+","+
                    Flights.arrivalText.getText();
            String s133 = Flights.airportDText.getText()+","+JourneyDetailsFrame.returnDate1.getText()+","+
                    Flights.departText.getText();
            JLabel departureText1 = new JLabel(s133);
            departureText1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            departureText1.setForeground(Color.black);
            departureText1.setBounds(300,60,500,37);
            panel3.add(departureText1);
            JLabel arrivalText1 = new JLabel(s122);
            arrivalText1.setFont(new Font("TimesNewRoman",Font.PLAIN,17));
            arrivalText1.setForeground(Color.black);
            arrivalText1.setBounds(720,60,500,37);
            panel3.add(arrivalText1);
            JLabel durationText1 = new JLabel(Flights.durationText.getText());
            durationText1.setBounds(1120,60,200,37);

            durationText1.setFont(new Font("TimesNewRoman",Font.PLAIN,19));
            panel3.add(durationText1);

            ticketNumber123 = new JLabel(pnrNumber);
            ticketNumber123.setVisible(false);
            ticketNumber123.setFont(new Font("TimesNewRoman",Font.PLAIN,15));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1300,60,200,37);
            panel3.add(ticketNumber123);
        }
        JPanel panel4 = new JPanel();
        panel4.setBounds(0,570,2180,90);
        panel4.setBackground(Color.white);
        panel4.setLayout(null);
        panel4.setForeground(Color.black);
        add(panel4);
        JLabel basePrice = new JLabel("BASE FARE");
        basePrice.setBounds(0,10,200,37);
        basePrice.setForeground(Color.black);
        basePrice.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel4.add(basePrice);
        JLabel taxes = new JLabel("TAXES");
        taxes.setBounds(300,10,200,37);
        taxes.setForeground(Color.black);
        taxes.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel4.add(taxes);
        JLabel totalPrice = new JLabel("TOTAL PRICE");
        totalPrice.setBounds(720,10,200,37);
        totalPrice.setForeground(Color.black);
        totalPrice.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel4.add(totalPrice);

        String s = Flights.priceText.getText();
        JLabel basePriceText = new JLabel(s);
        basePriceText.setBounds(0,40,200,37);

        basePriceText.setFont(new Font("TimesNewRoman",Font.PLAIN,19));
        panel4.add(basePriceText);
        JLabel taxesText = new JLabel("₹950.00");
        taxesText.setBounds(300,40,200,37);

        taxesText.setFont(new Font("TimesNewRoman",Font.PLAIN,19));
        panel4.add(taxesText);
        String s5 = s.substring(1,s.length());
        int total = Integer.parseInt(s5) + 950;
        String totalPriceOfFlight = "₹"+total;
        JLabel totalPriceText = new JLabel(totalPriceOfFlight);
        totalPriceText.setBounds(720,40,200,37);
        totalPriceText.setForeground(Color.RED);
        totalPriceText.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        panel4.add(totalPriceText);
        JButton pay = new JButton("PAY");
        pay.setBounds(1230,671,90,27);
        pay.setBackground(Color.RED);
        pay.setForeground(Color.WHITE);
        add(pay);
        JLabel status = new JLabel("STATUS");
        status.setBounds(900, 10, 200, 37);
        status.setForeground(Color.black);
        status.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(status);
        JLabel statusText = new JLabel("PENDING");
        statusText.setBounds(900, 40, 200, 37);
        statusText.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(statusText);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection dc = new DatabaseConnection();
                String s12 = Flights.airportSText.getText() + "," + JourneyDetailsFrame.departureDate1.getText() + "," +
                        Flights.departText.getText();
                String s13 = Flights.airportDText.getText() + "," + JourneyDetailsFrame.departureDate1.getText() + "," +
                        Flights.arrivalText.getText();
                String query = "";
                String s122 = "NA";
                String s133 = "NA";
                if (((String) JourneyDetailsFrame.trip.getSelectedItem()).equals("ROUND TRIP")) {
                    s122 = Flights.airportSText.getText() + "," + JourneyDetailsFrame.returnDate1.getText() + "," +
                            Flights.arrivalText.getText();
                    s133 = Flights.airportDText.getText() + "," + JourneyDetailsFrame.returnDate1.getText() + "," +
                            Flights.departText.getText();
                    s122 = "NA";
                    s133 = "NA";
                }
                if ((JourneyDetailsFrame.travellers1.getText()).equals("1")) {
                    query = "insert into reservation values('" + BookTicketTwo.name_text.getText() + "','NA','NA','NA','" +
                            BookTicket.phno_text.getText() + "','" + pnrNumber + "','" + code + "','" + Flights.flightText.getText() +
                            "','" + s12 + "','" + s13 + "','" + s133 + "','" + s122 + "','" + Flights.durationText.getText() + "','" + bookingId + "','" + totalPriceOfFlight + "')";
                }
                if ((JourneyDetailsFrame.travellers1.getText()).equals("2")) {
                    query = "insert into reservation values('" + BookTicketTwo.name_text.getText() + "','" + otherTravellersDetails.nameText.getText() + "','NA','NA','" +
                            BookTicket.phno_text.getText() + "','" + pnrNumber + "','" + code + "','" + Flights.flightText.getText() +
                            "','" + s12 + "','" + s13 + "','" + s133 + "','" + s122 + "','" + Flights.durationText.getText() + "','" + bookingId + "','" + totalPriceOfFlight + "')";
                }
                if ((JourneyDetailsFrame.travellers1.getText()).equals("3")) {
                    query = "insert into reservation values('" + BookTicketTwo.name_text.getText() + "','" + otherTravellersDetails.nameText.getText() + "','"
                            + otherTravellersDetails.nameText1.getText() + "','NA','" +
                            BookTicket.phno_text.getText() + "','" + pnrNumber + "','" + code + "','" + Flights.flightText.getText() +
                            "','" + s12 + "','" + s13 + "','" + s133 + "','" + s122 + "','" + Flights.durationText.getText() + "','" + bookingId + "','" + totalPriceOfFlight + "')";
                }
                if ((JourneyDetailsFrame.travellers1.getText()).equals("4")) {
                    query = "insert into reservation values('" + BookTicketTwo.name_text.getText() + "','" + otherTravellersDetails.nameText.getText() + "','"
                            + otherTravellersDetails.nameText1.getText() + "','" + otherTravellersDetails.nameText2.getText() + "','" +
                            BookTicket.phno_text.getText() + "','" + pnrNumber + "','" + code + "','" + Flights.flightText.getText() +
                            "','" + s12 + "','" + s13 + "','" + s133 + "','" + s122 + "','" + Flights.durationText.getText() + "','" + bookingId + "','" + totalPriceOfFlight + "')";
                }
                try {
                    dc.statement.executeUpdate(query);
                } catch (SQLException es) {
                    es.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Your payment of " + totalPriceOfFlight +
                        " was successfully completed");
                JOptionPane.showMessageDialog(null, "Your Ticket with pnr number: " +
                       pnrNumber + " is successfully booked.");
                ticketNumber12.setVisible(true);
                if(((String) JourneyDetailsFrame.trip.getSelectedItem()).equals("ROUND TRIP"))
                ticketNumber123.setVisible(true);
                pay.setText("PAID");
                statusText.setText("APPROVED");
                statusText.setForeground(Color.GREEN);
                pay.setBackground(Color.GREEN);
                pay.setVisible(false);

            }
                });
        }


    public static long numbGen() {
        long numb = (long)(Math.random() * 10000000 * 1000000);

        return numb;
    }



    public static void main(String[] args) {

       Ticket ticket = new Ticket();
    }
    public static long pnrNumber()
    {
        return (long) (Math.random() * 1000000);
    }
}
