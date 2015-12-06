import java.net.*;
import java.io.*;

/**
 * Created by user on 2015-11-01.
 */
public class Connection {
    private final int port = 28411;
    private OutputStream outputStream;
    private Socket socket;
    private String nick;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    //public Connection(){}

    public Connection(Socket s) throws IOException {
        this.socket=s;
        outputStream = socket.getOutputStream();
        dataOutputStream = new DataOutputStream(outputStream);
        dataInputStream = new DataInputStream(socket.getInputStream());
    }

    /*public Connection(InetAddress ipAddr, int port) {
        try {
            ip = ipAddr;
            ss = new ServerSocket(port);
            s1 = ss.accept();
            s = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void sendNickHello(String nick) throws IOException {
        dataOutputStream.write(("ChatApp 2015 user " + nick + "\n").getBytes());
        dataOutputStream.flush();
    }


    public void sendNickBusy(String nick) throws IOException{
        dataOutputStream.write(("ChatApp 2015 user " + nick + "busy" + "\n").getBytes());
        dataOutputStream.flush();
    }

    public void accept() throws IOException{
        dataOutputStream.write("Accepted\n".getBytes());
        dataOutputStream.flush();
    }

    public void reject() throws IOException{
        dataOutputStream.write("Rejected\n".getBytes());
        dataOutputStream.flush();
    }

    public void sendMessage(String l) throws IOException{
        dataOutputStream.write("Message\n".getBytes());
        dataOutputStream.write(l.getBytes());
        dataOutputStream.flush();
    }

    public void close() throws IOException {
        socket.close();
        dataOutputStream.close();
        dataInputStream.close();
        outputStream.close();
    }

    public boolean isOpen(){
        return !socket.isClosed();
    }

    public void disconnect() throws IOException{
        dataOutputStream.write("Disconnected\n".getBytes());
        dataOutputStream.flush();
        dataOutputStream.close();
        close();
    }

    public Command receive() throws IOException {
        String command = "";
        Command comand;
        int n;
        while (true) {
            if((n = dataInputStream.read()) == '\n') {
                break;
            } else
                command += (char) n;
        }
        comand = new Command(command.toUpperCase());
        if (command.startsWith("ChatApp")) {
            if (command.endsWith("busy")){
                //command for nickname busy
            }
            else{
                //command for nickname
                comand = new Command("Nick");}
        }

        if(command.toUpperCase().equals("MESSAGE")) {
            String message = "";
            while (true) {
                if((n = dataInputStream.read()) == '\n')
                    break;
                else
                    message += (char) n;
            }
            //command for message
        }
        return comand;
    }



    /*public static void main (String[] args) throws IOException {
        Connection con = new Connection("127.0.0.1",999);
        con.sendNickHello("farf");

    }*/
}
