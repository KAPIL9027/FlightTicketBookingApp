import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTicket extends JFrame {
    static String ticketNumber;

    ViewTicket() {
        setTitle("YOUR FLIGHT TICKET");
        setSize(2180, 1080);
        setVisible(true);
        setLayout(null);
        DatabaseConnection dbc = new DatabaseConnection();
        String name = "";
        String traveller2 = "";
        String traveller3 = "";
        String traveller4 = "";
        String pnr = "";
        String destination = "";
        String airline = "";
        String departure = "";
        String arrival = "";
        String departure1 = "";
        String arrival1 = "";
        String duration = "";
        String bookingid = "";
        String totalPrice = "";


        try
        {
            String query = "select * from reservation where phno = '"+ViewTicketFirst.phno_text.getText()+"'";
            ResultSet rs = dbc.statement.executeQuery(query);
            rs.next();
            name = rs.getString("name");
            traveller2 =  rs.getString("taveller2");
            traveller3 =  rs.getString("traveller3");
            traveller4 =  rs.getString("traveller4");
            pnr = rs.getString("pnr");
            destination = rs.getString("destination");
            airline = rs.getString("airline");
            departure = rs.getString("departure");
            arrival =   rs.getString("arrival");
            departure1 = rs.getString("departure1");
            arrival1 =   rs.getString("arrival1");
           duration =   rs.getString("duration");
            bookingid=   rs.getString("bookingid");
            totalPrice =   rs.getString("totalPrice");

        }
        catch (SQLException es)
        {
            es.printStackTrace();
        }
        String firstTwo = name.toUpperCase();
        String l3Digits = ViewTicketFirst.phno_text.getText();
        String ticketNumber = firstTwo.substring(0,2)+"0"+l3Digits.substring(10,13);
        int numberOfTravellers = 4;
        if((traveller2.equals("NA") && traveller3.equals("NA")) && traveller4.equals("NA") )
            numberOfTravellers = 1;
        if(!(traveller2.equals("NA")) && traveller3.equals("NA") && traveller4.equals("NA"))
            numberOfTravellers = 2;
        if((!traveller2.equals("NA") && !traveller3.equals("NA")) && traveller4.equals("NA"))
            numberOfTravellers = 3;



        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 2180, 100);
        add(panel);
        JLabel label = new JLabel("E-TICKET");
        label.setFont(new Font("TimesNewRoman", Font.BOLD, 60));
        label.setForeground(Color.RED);
        panel.add(label);
        JLabel flight = new JLabel("FLIGHT");
        JLabel eTicket = new JLabel("E-TICKET");
        JLabel referenceId = new JLabel("REFERENCE ID ");
        String bookingId = "" + bookingid;
        JLabel id = new JLabel(bookingId);
        flight.setBounds(50, 140, 200, 37);
        flight.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        add(flight);
        eTicket.setBounds(300, 140, 200, 37);
        eTicket.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        add(eTicket);
        referenceId.setBounds(550, 140, 450, 37);
        referenceId.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        add(referenceId);
        id.setBounds(950, 140, 450, 37);
        id.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        id.setForeground(Color.RED);
        add(id);
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 220, 2180, 210);
        panel2.setBackground(Color.white);
        panel2.setLayout(null);
        panel2.setForeground(Color.black);
        add(panel2);
        JLabel passDetails = new JLabel("PASSENGER(S) DETAILS");
        passDetails.setBounds(0, 0, 600, 37);
        passDetails.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        panel2.add(passDetails);
        JLabel border = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        border.setBounds(0, 50, 2180, 7);
        border.setForeground(Color.lightGray);
        panel2.add(border);
        JLabel name1 = new JLabel("NAME");
        name1.setBounds(0, 60, 200, 37);
        name1.setForeground(Color.black);
        name1.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(name1);
        JLabel destination1 = new JLabel("DESTINATION");
        destination1.setBounds(300, 60, 200, 37);
        destination1.setForeground(Color.black);
        destination1.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(destination1);
        JLabel meals = new JLabel("MEALS");
        meals.setBounds(520, 60, 200, 37);
        meals.setForeground(Color.black);
        meals.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(meals);
        JLabel baggage = new JLabel("BAGGAGE");
        baggage.setBounds(700, 60, 200, 37);
        baggage.setForeground(Color.black);
        baggage.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(baggage);
        JLabel seatNo = new JLabel("SEAT NO.");
        seatNo.setBounds(900, 60, 200, 37);
        seatNo.setForeground(Color.black);
        seatNo.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(seatNo);
        JLabel ticketNo = new JLabel("TICKET NO.");
        ticketNo.setBounds(1100, 60, 200, 37);
        ticketNo.setForeground(Color.black);
        ticketNo.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel2.add(ticketNo);
        JLabel basic = new JLabel("NA");
        basic.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        basic.setForeground(Color.black);
        basic.setBounds(520, 90, 200, 37);
        panel2.add(basic);
        JLabel baggage1 = new JLabel("15Kgs(Free)");
        baggage1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        baggage1.setForeground(Color.black);
        baggage1.setBounds(700, 90, 200, 37);
        panel2.add(baggage1);
        JLabel seatNo1 = new JLabel("NA");
        seatNo1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        seatNo1.setForeground(Color.black);
        seatNo1.setBounds(900, 90, 200, 37);
        panel2.add(seatNo1);
        JLabel name12 = new JLabel(name);
        name12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        name12.setForeground(Color.black);
        name12.setBounds(0, 90, 200, 37);
        panel2.add(name12);
        JLabel destination12 = new JLabel(destination);
        destination12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        destination12.setForeground(Color.black);
        destination12.setBounds(300, 90, 200, 37);
        panel2.add(destination12);
        JLabel ticketNumber1 = new JLabel(ticketNumber);
        ticketNumber1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
        ticketNumber1.setForeground(Color.black);
        ticketNumber1.setBounds(1100, 90, 200, 37);
        panel2.add(ticketNumber1);
        if (numberOfTravellers == 2) {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520, 120, 200, 37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700, 120, 200, 37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900, 120, 200, 37);
            panel2.add(seatNo12);
            JLabel name123 = new JLabel(traveller2);
            name123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name123.setForeground(Color.black);
            name123.setBounds(0, 120, 200, 37);
            panel2.add(name123);
            JLabel destination123 = new JLabel(destination);
            destination123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination123.setForeground(Color.black);
            destination123.setBounds(300, 120, 200, 37);
            panel2.add(destination123);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100, 120, 200, 37);
            panel2.add(ticketNumber12);
        }
        if (numberOfTravellers == 3) {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520, 120, 200, 37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700, 120, 200, 37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900, 120, 200, 37);
            panel2.add(seatNo12);
            JLabel name123 = new JLabel(traveller2);
            name123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name123.setForeground(Color.black);
            name123.setBounds(0, 120, 200, 37);
            panel2.add(name123);
            JLabel destination123 = new JLabel(destination);
            destination123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination123.setForeground(Color.black);
            destination123.setBounds(300, 120, 200, 37);
            panel2.add(destination123);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100, 120, 200, 37);
            panel2.add(ticketNumber12);

            JLabel basic12 = new JLabel("NA");
            basic12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic12.setForeground(Color.black);
            basic12.setBounds(520, 150, 200, 37);
            panel2.add(basic12);
            JLabel baggage123 = new JLabel("15Kgs(Free)");
            baggage123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage123.setForeground(Color.black);
            baggage123.setBounds(700, 150, 200, 37);
            panel2.add(baggage123);
            JLabel seatNo123 = new JLabel("NA");
            seatNo123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo123.setForeground(Color.black);
            seatNo123.setBounds(900, 150, 200, 37);
            panel2.add(seatNo123);
            JLabel name1234 = new JLabel(traveller3);
            name1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name1234.setForeground(Color.black);
            name1234.setBounds(0, 150, 200, 37);
            panel2.add(name1234);
            JLabel destination1234 = new JLabel(destination);
            destination1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination1234.setForeground(Color.black);
            destination1234.setBounds(300, 150, 200, 37);
            panel2.add(destination1234);
            JLabel ticketNumber123 = new JLabel(ticketNumber);
            ticketNumber123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1100, 150, 200, 37);
            panel2.add(ticketNumber123);

        }
        if (numberOfTravellers == 4) {
            JLabel basic1 = new JLabel("NA");
            basic1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic1.setForeground(Color.black);
            basic1.setBounds(520, 120, 200, 37);
            panel2.add(basic1);
            JLabel baggage12 = new JLabel("15Kgs(Free)");
            baggage12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage12.setForeground(Color.black);
            baggage12.setBounds(700, 120, 200, 37);
            panel2.add(baggage12);
            JLabel seatNo12 = new JLabel("NA");
            seatNo12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo12.setForeground(Color.black);
            seatNo12.setBounds(900, 120, 200, 37);
            panel2.add(seatNo12);
            JLabel name123 = new JLabel(traveller2);
            name123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name123.setForeground(Color.black);
            name123.setBounds(0, 120, 200, 37);
            panel2.add(name123);
            JLabel destination123 = new JLabel(destination);
            destination123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination123.setForeground(Color.black);
            destination123.setBounds(300, 120, 200, 37);
            panel2.add(destination123);
            JLabel ticketNumber12 = new JLabel(ticketNumber);
            ticketNumber12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1100, 120, 200, 37);
            panel2.add(ticketNumber12);

            JLabel basic12 = new JLabel("NA");
            basic12.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic12.setForeground(Color.black);
            basic12.setBounds(520, 150, 200, 37);
            panel2.add(basic12);
            JLabel baggage123 = new JLabel("15Kgs(Free)");
            baggage123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage123.setForeground(Color.black);
            baggage123.setBounds(700, 150, 200, 37);
            panel2.add(baggage123);
            JLabel seatNo123 = new JLabel("NA");
            seatNo123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo123.setForeground(Color.black);
            seatNo123.setBounds(900, 150, 200, 37);
            panel2.add(seatNo123);
            JLabel name1234 = new JLabel(traveller3);
            name1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name1234.setForeground(Color.black);
            name1234.setBounds(0, 150, 200, 37);
            panel2.add(name1234);
            JLabel destination1234 = new JLabel(destination);
            destination1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination1234.setForeground(Color.black);
            destination1234.setBounds(300, 150, 200, 37);
            panel2.add(destination1234);
            JLabel ticketNumber123 = new JLabel(ticketNumber);
            ticketNumber123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1100, 150, 200, 37);
            panel2.add(ticketNumber123);

            JLabel basic123 = new JLabel("NA");
            basic123.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            basic123.setForeground(Color.black);
            basic123.setBounds(520, 180, 200, 37);
            panel2.add(basic123);
            JLabel baggage1234 = new JLabel("15Kgs(Free)");
            baggage1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            baggage1234.setForeground(Color.black);
            baggage1234.setBounds(700, 180, 200, 37);
            panel2.add(baggage1234);
            JLabel seatNo1234 = new JLabel("NA");
            seatNo1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            seatNo1234.setForeground(Color.black);
            seatNo1234.setBounds(900, 180, 200, 37);
            panel2.add(seatNo1234);
            JLabel name12345 = new JLabel(traveller4);
            name12345.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            name12345.setForeground(Color.black);
            name12345.setBounds(0, 180, 200, 37);
            panel2.add(name12345);
            JLabel destination12345 = new JLabel(destination);
            destination12345.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            destination12345.setForeground(Color.black);
            destination12345.setBounds(300, 180, 200, 37);
            panel2.add(destination12345);
            JLabel ticketNumber1234 = new JLabel(ticketNumber);
            ticketNumber1234.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            ticketNumber1234.setForeground(Color.black);
            ticketNumber1234.setBounds(1100, 180, 200, 37);
            panel2.add(ticketNumber1234);
        }
        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 450, 2180, 100);
        panel3.setBackground(Color.white);
        panel3.setLayout(null);
        panel3.setForeground(Color.black);
        add(panel3);

        JLabel airLine = new JLabel("AIRLINE");
        airLine.setBounds(0, 10, 200, 37);
        airLine.setForeground(Color.black);
        airLine.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel3.add(airLine);
        JLabel departure0 = new JLabel("DEPARTURE");
        departure0.setBounds(300, 10, 200, 37);
        departure0.setForeground(Color.black);
        departure0.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel3.add(departure0);
        JLabel arrival0 = new JLabel("ARRIVAL");
        arrival0.setBounds(720, 10, 200, 37);
        arrival0.setForeground(Color.black);
        arrival0.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel3.add(arrival0);
        JLabel duration1 = new JLabel("DURATION");
        duration1.setBounds(1120, 10, 200, 37);
        duration1.setForeground(Color.black);
        duration1.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel3.add(duration1);
        JLabel pnr1 = new JLabel("PNR");
        pnr1.setBounds(1300, 10, 200, 37);
        pnr1.setForeground(Color.black);
        pnr1.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel3.add(pnr1);
        String tripType = "ROUND TRIP";
        if(departure1.equals("NA"))
            tripType = "ONE WAY";
        if (tripType.equals("ONE WAY")) {
            JLabel airlineText = new JLabel(airline);
            airlineText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            airlineText.setForeground(Color.black);
            airlineText.setBounds(0, 40, 200, 37);
            panel3.add(airlineText);

            JLabel departureText = new JLabel(departure);
            departureText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            departureText.setForeground(Color.black);
            departureText.setBounds(300, 40, 500, 37);
            panel3.add(departureText);
            JLabel arrivalText = new JLabel(arrival);
            arrivalText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            arrivalText.setForeground(Color.black);
            arrivalText.setBounds(720, 40, 500, 37);
            panel3.add(arrivalText);
            JLabel durationText = new JLabel(duration);
            durationText.setBounds(1120, 40, 200, 37);
            durationText.setForeground(Color.black);
            durationText.setFont(new Font("TimesNewRoman", Font.PLAIN, 19));
            panel3.add(durationText);

            JLabel ticketNumber12 = new JLabel(pnr);
            ticketNumber12.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1300, 40, 200, 37);
            panel3.add(ticketNumber12);
        }
        if (tripType.equals("ROUND TRIP")) {
            JLabel airlineText = new JLabel(airline);
            airlineText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            airlineText.setForeground(Color.black);
            airlineText.setBounds(0, 40, 200, 37);
            panel3.add(airlineText);

            JLabel departureText = new JLabel(departure);
            departureText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            departureText.setForeground(Color.black);
            departureText.setBounds(300, 40, 500, 37);
            panel3.add(departureText);
            JLabel arrivalText = new JLabel(arrival);
            arrivalText.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            arrivalText.setForeground(Color.black);
            arrivalText.setBounds(720, 40, 500, 37);
            panel3.add(arrivalText);
            JLabel durationText = new JLabel(duration);
            durationText.setBounds(1120, 40, 200, 37);

            durationText.setFont(new Font("TimesNewRoman", Font.PLAIN, 19));
            panel3.add(durationText);

            JLabel ticketNumber12 = new JLabel(pnr);
            ticketNumber12.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
            ticketNumber12.setForeground(Color.black);
            ticketNumber12.setBounds(1300, 40, 200, 37);
            panel3.add(ticketNumber12);

            JLabel airlineText1 = new JLabel(airline);
            airlineText1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            airlineText1.setForeground(Color.black);
            airlineText1.setBounds(0, 60, 200, 37);
            panel3.add(airlineText1);

            JLabel departureText1 = new JLabel(departure1);
            departureText1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            departureText1.setForeground(Color.black);
            departureText1.setBounds(300, 60, 500, 37);
            panel3.add(departureText1);
            JLabel arrivalText1 = new JLabel(arrival1);
            arrivalText1.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
            arrivalText1.setForeground(Color.black);
            arrivalText1.setBounds(720, 60, 500, 37);
            panel3.add(arrivalText1);
            JLabel durationText1 = new JLabel(duration);
            durationText1.setBounds(1120, 60, 200, 37);

            durationText1.setFont(new Font("TimesNewRoman", Font.PLAIN, 19));
            panel3.add(durationText1);

            JLabel ticketNumber123 = new JLabel(pnr);
            ticketNumber123.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
            ticketNumber123.setForeground(Color.black);
            ticketNumber123.setBounds(1300, 60, 200, 37);
            panel3.add(ticketNumber123);
        }
        JPanel panel4 = new JPanel();
        panel4.setBounds(0, 570, 2180, 90);
        panel4.setBackground(Color.white);
        panel4.setLayout(null);
        panel4.setForeground(Color.black);
        add(panel4);
        JLabel basePrice = new JLabel("BASE FARE");
        basePrice.setBounds(0, 10, 200, 37);
        basePrice.setForeground(Color.black);
        basePrice.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(basePrice);
        JLabel taxes = new JLabel("TAXES");
        taxes.setBounds(300, 10, 200, 37);
        taxes.setForeground(Color.black);
        taxes.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(taxes);
        JLabel totalPrice1 = new JLabel("TOTAL PRICE");
        totalPrice1.setBounds(720, 10, 200, 37);
        totalPrice1.setForeground(Color.black);
        totalPrice1.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(totalPrice1);
        int basePrice1 = Integer.parseInt(totalPrice.substring(1)) - 950;
        String s = totalPrice.substring(0,1)+basePrice1;
        JLabel basePriceText = new JLabel(s);
        basePriceText.setBounds(0, 40, 200, 37);

        basePriceText.setFont(new Font("TimesNewRoman", Font.PLAIN, 19));
        panel4.add(basePriceText);
        JLabel taxesText = new JLabel("₹950.00");
        taxesText.setBounds(300, 40, 200, 37);

        taxesText.setFont(new Font("TimesNewRoman", Font.PLAIN, 19));
        panel4.add(taxesText);

        JLabel totalPriceText = new JLabel(totalPrice);
        totalPriceText.setBounds(720, 40, 200, 37);
        totalPriceText.setForeground(Color.RED);
        totalPriceText.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(totalPriceText);
        JButton close = new JButton("CLOSE");
        close.setBounds(1230, 671, 90, 27);
        close.setBackground(Color.RED);
        close.setForeground(Color.WHITE);
        add(close);
        JLabel status = new JLabel("STATUS");
        status.setBounds(900, 10, 200, 37);
        status.setForeground(Color.black);
        status.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(status);
        JLabel statusText = new JLabel("APPROVED");
        statusText.setBounds(900, 40, 200, 37);
        statusText.setForeground(Color.GREEN);
        statusText.setFont(new Font("TimesNewRoman", Font.BOLD, 19));
        panel4.add(statusText);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}