import javax.swing.*;
import java.awt.*;

public class UserGuide extends JFrame {
    UserGuide()
    {
        setTitle("HOW TO BOOK A TICKET");
        setVisible(true);
        setSize(1080,720);
        JPanel panel = new JPanel();
        setLayout(null);
        panel.setBounds(100,50,819,500);
        setBackground(Color.RED);
        panel.add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Untitled.png"))));
        add(panel);
    }

    public static void main(String[] args) {
        UserGuide ug = new UserGuide();
    }
}
