import java.io.*;
import java.net.*;

/**
 * Created by user on 2015-11-08.
 */
public class Caller {
    private String localNick="Anonymous";
    private InetAddress remoteAddress;
    private int port;
    private String remoteNick;
    private Socket socket;

    public Caller(){}

    public Caller(String localNick){
        this.localNick = localNick;
    }

    public Caller (String localNick, InetAddress remoteAddress) throws IOException {
        this.localNick=localNick;
        socket = new Socket(remoteAddress,port);
    }

    public Caller(String address, int port) throws IOException {
        this.port=port;
        this.remoteAddress=this.remoteAddress.getByName(address);
        socket = new Socket(this.remoteAddress,port);
    }

    public Connection call() throws IOException {
        if(socket==null){socket = new Socket(remoteAddress,port);}
        Connection c = new Connection(socket, localNick);
        return c;
    }

    public String getLocalNick(){
        return localNick;
    }

    InetAddress	getRemoteAddress(){
        return remoteAddress;
    }

    public int getPort() {
        return port;
    }
    public Socket getSocket(){
        return socket;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getNick() {
        return remoteNick;
    }

    public void setNick(String nick) {
        this.remoteNick = nick;
    }

    public static enum CallStatus {
        BUSY, NO_SERVICE, NOT_ACCESSIBLE, OK, REJECTED;
    }

    //public CallStatus getStatus(){return callStatus;}

    public void setLocalNick(String localNick){
        this.localNick = localNick;
    }

    public void setRemoteAddress(InetAddress remoteAddress){
        this.remoteAddress = remoteAddress;
    }

    public String toString(){
        return localNick+" "+remoteAddress.toString();
    }

    /*static void main(java.lang.String[] args){

    }*/
}
