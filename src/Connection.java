import java.net.*;
import java.io.*;

/**
 * Created by user on 2015-11-01.
 */
public class Connection {
    private Socket s, s1;
    private ServerSocket ss;
    private InetAddress ip;
    boolean open=false;

    public Connection(String ipAddr, int port) {
        try {
            ip = InetAddress.getByName(ipAddr);
            ss = new ServerSocket(port);
            s1 = ss.accept();
            s = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendNickHello(String nick) throws IOException {
        //while (true){
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            String l = "ChatApp 2015 user "+nick;
            String line = new String(l.getBytes(),"UTF-8");
            line+="\n";
            out.write(line);
            out.flush();
        //    break;
        //}
    }

    void sendNickBusy(String nick) throws IOException{
        //while (true){
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            String l = "ChatApp 2015 user "+nick+" busy.";
            String line = new String(l.getBytes(),"UTF-8");
            line+="\n";
            out.write(line);
            out.flush();
        //    break;
        //}
    }

    void accept() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Accepted...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
        open=true;
    }

    void reject() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Rejected...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
    }

    void sendMessage(){

    }

    void close() throws IOException {
        s.close();
        s1.close();
        ss.close();
        open=false;
    }

    boolean isOpen(){
        return open;
    }

    void disconnect() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Disconnected...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
    }

    /*Command receive(){
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Command l = in.read();
        return l;
    }*/

    public static void main (String[] args) throws IOException {
        Connection con = new Connection("127.0.0.1",999);
        con.sendNickHello("farf");

    }
}
