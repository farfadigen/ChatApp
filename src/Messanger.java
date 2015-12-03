import javax.swing.*;
import java.io.IOException;

/**
 * Created by user on 2015-11-19.
 */
public class Messanger extends Thread{
    private Connection connection;
    private JTextArea textArea;

    public Messanger(Connection connection, JTextArea textArea){
        this.connection=connection;
        this.textArea=textArea;
    }

    public void run(){
        String l;
        while(true){
            try {
                l=connection.receive();
                textArea.append(l);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
