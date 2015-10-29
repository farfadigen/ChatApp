
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ButtonTest {
    public static void main(String []args){
        ButtonFrame frame= new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


class ButtonFrame extends JFrame{
    public ButtonFrame(){
        setSize(1000,500);
        setTitle("Button");
        ButtonPanel panel=new ButtonPanel();
        add(panel);
    }

}


class ButtonPanel extends JPanel{
    public ButtonPanel(){
        JButton yellowButton=new JButton("yellow");
        JButton blueButton=new JButton("blue");
        JButton greenButton=new JButton("green");

        add(yellowButton);
        add(blueButton);
        add(greenButton);

        ColorAction yellowAction=new ColorAction(Color.yellow);
        ColorAction blueAction=new ColorAction(Color.blue);
        ColorAction greenAction=new ColorAction(Color.green);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        greenButton.addActionListener(greenAction);
    }


    private class ColorAction implements ActionListener{
        public ColorAction(Color c){
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event){
            setBackground(backgroundColor);
        }

        private Color backgroundColor;
    }
}