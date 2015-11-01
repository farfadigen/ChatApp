import java.net.*;
import java.io.*;

/**
 * Created by user on 2015-11-01.
 */
public class connector {
    private Socket s, s1;
    private ServerSocket ss;
    private InetAddress ip;

    public connector(String ipaddr, int port) {
        try {
            ip = InetAddress.getByName(ipaddr);
            ss = new ServerSocket(port);
            s1 = ss.accept();
            s = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendNickHello(String nick) throws IOException {
        while (true){
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            String l = "ChatApp 2015 user "+nick;
            String line = new String(l.getBytes(),"UTF-8");
            line+="\n";
            out.write(line);
            out.flush();
            break;
        }
    }

    void sendNickBusy(String nick) throws IOException{
        while (true){
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            String l = "ChatApp 2015 user "+nick+" busy.";
            String line = new String(l.getBytes(),"UTF-8");
            line+="\n";
            out.write(line);
            out.flush();
            break;
        }
    }

    void accept() {

    }

    void reject() {

    }

    void sendMessage(){

    }

    void disconnect() {

    }

    /*Command receive(){

    }*/

    /*public static void main (String[] args) throws IOException {
        connector con = new connector("127.0.0.1",999);
        con.sendNickHello("farf");

    }*/
}
