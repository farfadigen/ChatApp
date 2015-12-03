/**
 * Created by Маша on 01.11.2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;


class User_Window{

    public JFrame frame;
    private Connection connection;
    private Caller caller;
    private CallListener callListener;
    private CallListenerThread callListenerThread;
    private Command command;


    public User_Window() {
        draw();
    }


    private void draw() {
        frame = new JFrame();
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));


        JPanel chat_panel = new JPanel();

        JLabel Local_login = new JLabel("Local login");

        final JTextField local_log = new JTextField();
        local_log.setBackground(Color.GREEN);
        local_log.setColumns(10);

        chat_panel.add(Local_login);
        chat_panel.add(local_log);


        frame.add(chat_panel);


        JButton ApplyButton = new JButton("APPLY");
        ApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callListener = new CallListener();
                caller = new Caller();
                if(local_log.equals("")){

                }
                else{
                    callListener.setLocalNick(local_log.getText());
                    caller.setLocalNick(local_log.getText());
                }
            }
        });
        chat_panel.add(ApplyButton);


        JLabel Remote_log = new JLabel("Remote login");

        chat_panel.add(Remote_log);

        JTextField TRemote_log= new JTextField();
        TRemote_log.setBackground(Color.GREEN);
        TRemote_log.setColumns(10);
        chat_panel.add(TRemote_log);



        JLabel Remote_addr = new JLabel("Remote addr");

        chat_panel.add(Remote_addr);

        final JTextField TRemote_addr = new JTextField();
        TRemote_addr.setColumns(10);
        TRemote_addr.setBackground(Color.GREEN);
        chat_panel.add(TRemote_addr);

        final JTextArea textArea = new JTextArea(23,80);
        textArea.setBackground(Color.CYAN);

        JButton SendBut = new JButton("CONNECT");
        SendBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = new String(TRemote_addr.getText());
                try {
                    Socket socket = new Socket("files.litvinov.in.ua",28411);
                    connection = new Connection(socket);
                    connection.sendNickHello("Farf");
                    String l = connection.receive();
                    textArea.append(l);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        chat_panel.add(SendBut);


        JButton DiscBut = new JButton("DISCONNECT");
        chat_panel.add(DiscBut);


        JPanel message_panel= new JPanel();



        message_panel.add(textArea);

        frame.add(message_panel);


        JPanel Send_panel = new JPanel();
        Send_panel.setLayout(new BoxLayout(Send_panel, BoxLayout.X_AXIS));



        final JTextField Enter_field = new JTextField();
        Enter_field.setMaximumSize(new Dimension(800, 100));

        Enter_field.setBackground(Color.WHITE);
        JButton btnNewButton = new JButton("SEND");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection.sendMessage(Enter_field.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Send_panel.add(Enter_field);
        Send_panel.add(btnNewButton);

        frame.add(Send_panel);

    }

    public void show(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        User_Window window = new User_Window();
        window.show();

    }

}



