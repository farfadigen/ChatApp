/**
 * Created by Маша on 08.10.2015.
 */
import java.awt.*;
import javax.swing.*;


public class Frame{

    public static void main(String[] args) {

        JFrame frame = new JFrame("FrameDemo");
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel myLabel = new JLabel("Привет, ВОВА!", SwingConstants.CENTER);
        myLabel.setFont(new Font("Red", Font.LAYOUT_LEFT_TO_RIGHT, 40));
        myLabel.setBackground(Color.blue);
        myLabel.setOpaque(true);
        myLabel.setPreferredSize(new Dimension(500, 500));

        frame.getContentPane().add(myLabel, BorderLayout.NORTH);

    }
}
