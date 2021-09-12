import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddCustomersDetails extends JFrame implements ActionListener {

    JLabel passportNumber;
    JLabel Address;
    JLabel nationality;
    JLabel name;
    JLabel gender;
    JLabel phno;
    JButton submit;
    JButton reset;
    JButton cancel;
    JLabel addCustomerDetails;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField7;
   JRadioButton radioButton1;
   JRadioButton radioButton2;
    public AddCustomersDetails()
    {
        setTitle("ADD PASSENGER DETAILS");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setSize(1100,900);
        setVisible(true);
        Font f1 = new Font("TimesNewRoman",Font.BOLD,17);
        addCustomerDetails = new JLabel("ADD CUSTOMER DETAILS");

        addCustomerDetails.setBounds(420,24,442,35);
        addCustomerDetails.setFont(new Font("TimesNewRoman",Font.BOLD,31));
        addCustomerDetails.setForeground(Color.RED);
        add(addCustomerDetails);
        passportNumber = new JLabel("PASSPORT NO.");
        passportNumber.setFont(f1);
        passportNumber.setBounds(60,80,150,27);
        add(passportNumber);
        Address = new JLabel("ADDRESS");
        Address.setBounds(60,120,150,27);
        Address.setFont(f1);
        add(Address);
        nationality = new JLabel("NATIONALITY");
        nationality.setBounds(60,170,150,27);
        nationality.setFont(f1);
        add(nationality);
        name = new JLabel("NAME");
        name.setBounds(60,220,150,27);
        name.setFont(f1);
        add(name);
        gender = new JLabel("GENDER");
        gender.setBounds(60,270,150,27);
        gender.setFont(f1);
        add(gender);
        phno = new JLabel("PHONE NO.");
        phno.setFont(f1);
        phno.setBounds(60,320,150,27);
        add(phno);
        submit = new JButton("SUBMIT");
        submit.setBounds(200,600,150,30);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.WHITE);
        add(submit);
        reset = new JButton("RESET");
        reset.setBounds(400,600,150,30);
        reset.setBackground(Color.RED);
        reset.setForeground(Color.WHITE);
        add(reset);
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(600,600,150,30);
        add(cancel);
        textField1 = new JTextField();
        textField1.setBounds(200,80,150,27);
        add(textField1);
        textField2 = new JTextField();
        textField2.setBounds(200,120,150,27);
        add(textField2);
        textField3 = new JTextField();
        textField3.setBounds(200,170,150,27);
        add(textField3);
        textField4 = new JTextField();
        textField4.setBounds(200,220,150,27);
        add(textField4);
        textField5 = new JTextField("+91");
        textField5.setBounds(200,320,150,27);
        add(textField5);
        radioButton1 = new JRadioButton("MALE");
        radioButton1.setBounds(200,270,70,27);
        radioButton1.setBackground(Color.WHITE);
        add(radioButton1);
        radioButton2 = new JRadioButton("FEMALE");
        radioButton2.setBounds(280,270,70,27);
        radioButton2.setBackground(Color.WHITE);
        add(radioButton2);

        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("emp.png")));
        image.setBounds(450,80,280,410);
        add(image);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        reset.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(submit))
        {
            String passport_number = textField1.getText();
            String address = textField2.getText();
            String nationality = textField3.getText();
            String name = textField4.getText();
            String phno = textField5.getText();
            String gender = null;
            if(radioButton1.isSelected())
            {
                gender = "male";
            }
            if(radioButton2.isSelected())
            {
                gender = "female";
            }
            try
            {
                DatabaseConnection dc = new DatabaseConnection();
                String query = "insert into PassengerDetails values('"+passport_number
                        +"','"+address+"','"+nationality+"','"+name+"','"+gender+"','"+phno+"')";
                 dc.statement.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Your Details are added!!!");
            }
            catch(SQLException es)
            {
                es.printStackTrace();
            }


        }
        if(e.getSource().equals(cancel))
        {
            setVisible(false);
        }
        if(e.getSource().equals(reset))
        {
          textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField7.setText("");

        }
    }

    public static void main(String[] args) {
        AddCustomersDetails acd = new AddCustomersDetails();
    }



}
