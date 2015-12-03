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

    public Connection(){}

    public Connection(Socket s){
        this.s=s;
    }

    public Connection(InetAddress ipAddr, int port) {
        try {
            ip = ipAddr;
            ss = new ServerSocket(port);
            s1 = ss.accept();
            s = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendNickHello(String nick) throws IOException {
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

    public void sendNickBusy(String nick) throws IOException{
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

    public void accept() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Accepted...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
        open=true;
    }

    public void reject() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Rejected...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
    }

    public void sendMessage(String l) throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
<<<<<<< HEAD
       // String m = new String
        String line = new String(l.getBytes(),"UTF-8");
=======
        String m = new String("Message: "); m+=l;
        String line = new String(m.getBytes(),"UTF-8");
>>>>>>> cf1bd8e9d687968d2de074c0db7d9638d9b55989
        line+="\n";
        out.write(line);
        out.flush();
    }

    public void close() throws IOException {
        s.close();
        s1.close();
        ss.close();
        open=false;
    }

    public boolean isOpen(){
        return open;
    }

    public void disconnect() throws IOException{
        OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
        String l = "Disconnected...";
        String line = new String(l.getBytes(),"UTF-8");
        line+="\n";
        out.write(line);
        out.flush();
    }

    public String receive() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String l = null;
        l = in.readLine();
        return l;
    }



    /*public static void main (String[] args) throws IOException {
        Connection con = new Connection("127.0.0.1",999);
        con.sendNickHello("farf");

    }*/
}
