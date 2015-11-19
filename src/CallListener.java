import java.io.*;
import java.net.*;

public class CallListener {

    public String localNick = "Unnamed";
    public String localIP;
    public int port = 999;
    Socket incoming;
    InetAddress ip;
    public SocketAddress listenAddress;
    public String remoteNick;
    public SocketAddress remoteAddress;
    private boolean busy = false;

    public CallListener() {

    }

    public CallListener(String localNick) {
        this.localNick = localNick;
    }


    public CallListener(String localNick, String localIP) {
        this(localNick);
        this.localIP = localIP;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {

        }
    }

    public Connection getConnection() {
        System.out.println("Waiting for a client...");
        try {
            ServerSocket s = new ServerSocket(port);
            Socket incoming = s.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(incoming.getOutputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection connection = new Connection(incoming);
        return connection;
    }


    public String getLocalNick() {
        return localNick;
    }

    public boolean isBusy(){
        return busy;
    }

    public SocketAddress getListenAddress(){
        return listenAddress;
    }

    public String getRemoteNick(){
        return remoteNick;
    }

    public SocketAddress getRemoteAddress(){
        return remoteAddress;
    }

    public void setBusy(boolean busy){
        this.busy=busy;
    }

    public void setLocalNick(String nick){
        this.localNick=nick;
    }
}