import java.io.*;
import java.net.*;
import java.sql.Connection;

public class CallListener {

    public String localNick = "Unnamed";
    public String localIP;
    public int port = 1999;
    Socket incoming;
    InetAddress ip;
    public SocketAddress listenAddress;
    public String remoteNick;
    public SocketAddress remoteAddress;

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

    public String getConnection() {
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
        return null;
    }


    public String getLocalNick() {
        return localNick;
    }

    public boolean isBusy(){

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


}