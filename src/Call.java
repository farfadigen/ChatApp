import javax.swing.*;
import java.awt.*;

/**
 * Created by Маша on 08.12.2015.
 */
public class Call extends JFrame {

        private JLabel Label;
        private JButton accept;
        private JButton reject;

    public Call() {

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            Label = new JLabel("                         User wants to chat" );
            accept = new JButton("Accept");
            reject = new JButton("Reject");

            JPanel buttonsPanel = new JPanel(new FlowLayout());

            add(Label, BorderLayout.NORTH);
            buttonsPanel.add(accept);
            buttonsPanel.add(reject);
            add(buttonsPanel, BorderLayout.SOUTH);

        }

        public static void main(String[] args) {
            Call app = new Call();
            app.setVisible(true);
            app.setSize(300,100);

        }


    }



