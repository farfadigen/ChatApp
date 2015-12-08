import javax.swing.*;
import java.awt.*;

/**
 * Created by Маша on 08.12.2015.
 */
public class BusyForm extends JFrame {
    private JLabel Label;

    private JButton OK;

    public BusyForm() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Label = new JLabel("                  User is busy.  Please, call later" );

        OK = new JButton("OK");

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        add(Label,BorderLayout.NORTH);


        buttonsPanel.add(OK);

        add(buttonsPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        BusyForm app = new BusyForm();
        app.setVisible(true);
        app.setSize(300,100);

    }
}
