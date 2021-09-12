import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class otherTravellersDetails extends JFrame {
    static JTextField nameText;
    JTextField ageText;
    JComboBox<String> gender1;
    static JTextField nameText1;
    JTextField ageText1;
    JComboBox<String> gender2;
    static JTextField nameText2;
    JTextField ageText2;
    JComboBox<String> gender3;
    otherTravellersDetails() {
        setTitle("GIVE OTHER TRAVELLERS INFORMATION");
        setLayout(null);
        setSize(2180, 1080);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
         int otherTravellers = (Integer.parseInt(JourneyDetailsFrame.travellers1.getText())) - 1;
        String[] genderText = {"MALE", "FEMALE"};
         if(otherTravellers == 1)
         {
             JPanel panel1 = new JPanel();
             panel1.setLayout(null);
             panel1.setBounds(50, 50, 400, 500);
             panel1.setBackground(Color.RED);
             panel1.setForeground(Color.white);
             add(panel1);
             JLabel traveller2 = new JLabel("TRAVELLER 2");
             traveller2.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             traveller2.setBounds(50, 40, 250, 37);
             traveller2.setForeground(Color.white);
             panel1.add(traveller2);
             JLabel name = new JLabel("NAME");
             name.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             name.setBounds(10, 100, 250, 37);
             name.setForeground(Color.white);
             panel1.add(name);
             nameText = new JTextField();
             nameText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             nameText.setBounds(160, 100, 200, 37);
             nameText.setBackground(Color.white);
             nameText.setForeground(Color.black);
             panel1.add(nameText);

             JLabel age = new JLabel("AGE");
             age.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             age.setBounds(10, 220, 250, 37);
             age.setForeground(Color.white);
             panel1.add(age);
             ageText = new JTextField();
             ageText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             ageText.setBounds(160, 220, 200, 37);
             ageText.setBackground(Color.white);
             ageText.setForeground(Color.black);
             panel1.add(ageText);

             JLabel gender = new JLabel("GENDER");
             gender.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             gender.setBounds(10, 340, 250, 37);
             gender.setForeground(Color.white);
             panel1.add(gender);

             gender1 = new JComboBox<>(genderText);
             gender1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             gender1.setBounds(160, 340, 200, 37);
             gender1.setBackground(Color.white);
             gender1.setForeground(Color.black);
             panel1.add(gender1);

         }
         else if (otherTravellers == 2)
         {
             JPanel panel1 = new JPanel();
             panel1.setLayout(null);
             panel1.setBounds(50, 50, 400, 500);
             panel1.setBackground(Color.RED);
             panel1.setForeground(Color.white);
             add(panel1);
             JLabel traveller2 = new JLabel("TRAVELLER 2");
             traveller2.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             traveller2.setBounds(50, 40, 250, 37);
             traveller2.setForeground(Color.white);
             panel1.add(traveller2);
             JLabel name = new JLabel("NAME");
             name.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             name.setBounds(10, 100, 250, 37);
             name.setForeground(Color.white);
             panel1.add(name);
             nameText = new JTextField();
             nameText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             nameText.setBounds(160, 100, 200, 37);
             nameText.setBackground(Color.white);
             nameText.setForeground(Color.black);
             panel1.add(nameText);

             JLabel age = new JLabel("AGE");
             age.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             age.setBounds(10, 220, 250, 37);
             age.setForeground(Color.white);
             panel1.add(age);
             ageText = new JTextField();
             ageText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             ageText.setBounds(160, 220, 200, 37);
             ageText.setBackground(Color.white);
             ageText.setForeground(Color.black);
             panel1.add(ageText);

             JLabel gender = new JLabel("GENDER");
             gender.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             gender.setBounds(10, 340, 250, 37);
             gender.setForeground(Color.white);
             panel1.add(gender);

             gender1 = new JComboBox<>(genderText);
             gender1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             gender1.setBounds(160, 340, 200, 37);
             gender1.setBackground(Color.white);
             gender1.setForeground(Color.black);
             panel1.add(gender1);
             JPanel panel2 = new JPanel();
             panel2.setLayout(null);
             panel2.setBounds(500, 50, 400, 500);
             panel2.setBackground(Color.RED);
             panel2.setForeground(Color.white);
             JLabel traveller3 = new JLabel("TRAVELLER 3");
             traveller3.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             traveller3.setBounds(50, 40, 250, 37);
             traveller3.setForeground(Color.white);
             panel2.add(traveller3);
             JLabel name1 = new JLabel("NAME");
             name1.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             name1.setBounds(10, 100, 250, 37);
             name1.setForeground(Color.white);
             panel2.add(name1);
             nameText1 = new JTextField();
             nameText1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             nameText1.setBounds(160, 100, 200, 37);
             nameText1.setBackground(Color.white);
             nameText1.setForeground(Color.black);
             panel2.add(nameText1);

             JLabel age1 = new JLabel("AGE");
             age1.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             age1.setBounds(10, 220, 250, 37);
             age1.setForeground(Color.white);
             panel2.add(age1);
             ageText1 = new JTextField();
             ageText1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             ageText1.setBounds(160, 220, 200, 37);
             ageText1.setBackground(Color.white);
             ageText1.setForeground(Color.black);
             panel2.add(ageText1);

             JLabel gender12 = new JLabel("GENDER");
             gender12.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             gender12.setBounds(10, 340, 250, 37);
             gender12.setForeground(Color.white);
             panel2.add(gender12);
             gender2 = new JComboBox<>(genderText);
             gender2.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             gender2.setBounds(160, 340, 200, 37);
             gender2.setBackground(Color.white);
             gender2.setForeground(Color.black);
             panel2.add(gender2);
             add(panel2);

         }

         else {
             JPanel panel1 = new JPanel();
             panel1.setLayout(null);
             panel1.setBounds(50, 50, 400, 500);
             panel1.setBackground(Color.RED);
             panel1.setForeground(Color.white);
             add(panel1);
             JLabel traveller2 = new JLabel("TRAVELLER 2");
             traveller2.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             traveller2.setBounds(50, 40, 250, 37);
             traveller2.setForeground(Color.white);
             panel1.add(traveller2);
             JLabel name = new JLabel("NAME");
             name.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             name.setBounds(10, 100, 250, 37);
             name.setForeground(Color.white);
             panel1.add(name);
             nameText = new JTextField();
             nameText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             nameText.setBounds(160, 100, 200, 37);
             nameText.setBackground(Color.white);
             nameText.setForeground(Color.black);
             panel1.add(nameText);

             JLabel age = new JLabel("AGE");
             age.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             age.setBounds(10, 220, 250, 37);
             age.setForeground(Color.white);
             panel1.add(age);
             ageText = new JTextField();
             ageText.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             ageText.setBounds(160, 220, 200, 37);
             ageText.setBackground(Color.white);
             ageText.setForeground(Color.black);
             panel1.add(ageText);

             JLabel gender = new JLabel("GENDER");
             gender.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             gender.setBounds(10, 340, 250, 37);
             gender.setForeground(Color.white);
             panel1.add(gender);

             gender1 = new JComboBox<>(genderText);
             gender1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             gender1.setBounds(160, 340, 200, 37);
             gender1.setBackground(Color.white);
             gender1.setForeground(Color.black);
             panel1.add(gender1);

             JPanel panel2 = new JPanel();
             panel2.setLayout(null);
             panel2.setBounds(500, 50, 400, 500);
             panel2.setBackground(Color.RED);
             panel2.setForeground(Color.white);
             JLabel traveller3 = new JLabel("TRAVELLER 3");
             traveller3.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             traveller3.setBounds(50, 40, 250, 37);
             traveller3.setForeground(Color.white);
             panel2.add(traveller3);
             JLabel name1 = new JLabel("NAME");
             name1.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             name1.setBounds(10, 100, 250, 37);
             name1.setForeground(Color.white);
             panel2.add(name1);
             nameText1 = new JTextField();
             nameText1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             nameText1.setBounds(160, 100, 200, 37);
             nameText1.setBackground(Color.white);
             nameText1.setForeground(Color.black);
             panel2.add(nameText1);

             JLabel age1 = new JLabel("AGE");
             age1.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             age1.setBounds(10, 220, 250, 37);
             age1.setForeground(Color.white);
             panel2.add(age1);
             ageText1 = new JTextField();
             ageText1.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             ageText1.setBounds(160, 220, 200, 37);
             ageText1.setBackground(Color.white);
             ageText1.setForeground(Color.black);
             panel2.add(ageText1);

             JLabel gender12 = new JLabel("GENDER");
             gender12.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
             gender12.setBounds(10, 340, 250, 37);
             gender12.setForeground(Color.white);
             panel2.add(gender12);
             gender2 = new JComboBox<>(genderText);
             gender2.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
             gender2.setBounds(160, 340, 200, 37);
             gender2.setBackground(Color.white);
             gender2.setForeground(Color.black);
             panel2.add(gender2);
             add(panel2);

             JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.RED);
        panel3.setBounds(950, 50, 400, 500);
        panel3.setForeground(Color.white);
        add(panel3);
        JLabel traveller4 = new JLabel("TRAVELLER 4");
        traveller4.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        traveller4.setBounds(50, 40, 250, 37);
        traveller4.setForeground(Color.white);
        panel3.add(traveller4);
        JLabel name2 = new JLabel("NAME");
        name2.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        name2.setBounds(10, 100, 250, 37);
        name2.setForeground(Color.white);
        panel3.add(name2);
        nameText2 = new JTextField();
        nameText2.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
        nameText2.setBounds(160, 100, 200, 37);
        nameText2.setBackground(Color.white);
        nameText2.setForeground(Color.black);
        panel3.add(nameText2);

        JLabel age2 = new JLabel("AGE");
        age2.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        age2.setBounds(10, 220, 250, 37);
        age2.setForeground(Color.white);
        panel3.add(age2);
        ageText2 = new JTextField();
        ageText2.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
        ageText2.setBounds(160, 220, 200, 37);
        ageText2.setBackground(Color.white);
        ageText2.setForeground(Color.black);
        panel3.add(ageText2);

        JLabel gender123 = new JLabel("GENDER");
        gender123.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
        gender123.setBounds(10, 340, 250, 37);
        gender123.setForeground(Color.white);
        panel3.add(gender123);
        gender3 = new JComboBox<>(genderText);
        gender3.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
        gender3.setBounds(160, 340, 200, 37);
        gender3.setBackground(Color.white);
        gender3.setForeground(Color.black);
        panel3.add(gender3);

           }
        JButton bookTicket = new JButton("BOOK TICKET-->");
        bookTicket.setBackground(Color.RED);
        bookTicket.setForeground(Color.WHITE);
        bookTicket.setBounds(1010, 650, 200, 37);

        add(bookTicket);
        bookTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new Ticket();
                 setVisible(false);
            }
        });
    }

    public static void main(String[] args) {

        otherTravellersDetails ottd = new otherTravellersDetails();
    }
}
