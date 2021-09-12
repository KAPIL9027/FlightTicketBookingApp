import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightInformation extends JFrame {
    JTable table;
    JLabel flightInformation;
    JLabel flightName;
    JButton show;
    JTextField textField;
    public FlightInformation()
    {
        setTitle("FLIGHT INFORMATION");
        setLayout(null);
        setSize(1100,900);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        table = new JTable();

        textField = new JTextField();
        flightInformation = new JLabel(" FLIGHT INFORMATION");
        flightInformation.setFont(new Font("TimesNewRoman",Font.BOLD,33));
        flightInformation.setForeground(Color.RED);
        add(flightInformation);
        flightName = new JLabel(" Flight Name: ");
        flightName.setFont(new Font("TimesNewRoman",Font.BOLD,19));
        add(flightName);
        flightName.setBounds(50,100,200,30);
        flightInformation.setBounds(50,20,570,35);
        show = new JButton(" SHOW ");
        show.setFont(new Font("TimesNewRoman",Font.BOLD,20));
        show.setBounds(220,150,120,30);
        show.setBackground(Color.RED);
        show.setForeground(Color.WHITE);
        textField.setBounds(220,100,200,30);
        add(show);
        add(textField);
        table.setBounds(23,250,1000,300);
        add(table);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(220,150,120,30);

        JLabel flightCode = new JLabel("FLIGHT NAME");
        JLabel flightName1 = new JLabel("FLIGHT CODE");
        JLabel source = new JLabel("SOURCE");
        JLabel destination = new JLabel("DESTINATION");
        JLabel date = new JLabel("DATE");
        JLabel capacity = new JLabel("CAPACITY");
        JLabel classCode = new JLabel("CLASS CODE");
        JLabel className = new JLabel("CLASS NAME");
        flightCode.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        flightName1.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        source.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        destination.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        date.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        className.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        classCode.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        capacity.setFont(new Font("TimesNewRoman",Font.BOLD,13));
        flightCode.setBounds(23,220,111,14);
        flightName1.setBounds(145,220,111,14);
        source.setBounds(275,220,111,14);
        destination.setBounds(395,220,111,14);
        date.setBounds(535,220,111,14);
        capacity.setBounds(650,220,111,14);
        classCode.setBounds(795,220,111,14);
       className.setBounds(925,220,111,14);
        add(flightName1);
        add(flightCode);
        add(source);
        add(destination);
        add(date);
        add(className);
        add(classCode);
        add(capacity);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnection dc = new DatabaseConnection();
                String userInput = textField.getText();
                String query = "select * from flightinfo where Fname = '"+userInput+"'";
             try {
                ResultSet rs =  dc.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
             }
             catch(SQLException err)
             {
                 err.printStackTrace();
             }
            }
        });


    }
    public static void main(String[] args)
    {
        FlightInformation fi = new FlightInformation();

    }
}
