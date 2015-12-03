import java.net.*;

/**
 * Created by user on 2015-11-08.
 */
public class Caller {
    private String localNick;
    private InetAddress remoteAddress;
    private CallStatus callStatus;
    private String remoteNick;

    public Caller(){
        localNick = "Anonymous";
    }

    public Caller(String localNick){
        this.localNick = localNick;
    }

    public Caller (String localNick, InetAddress remoteAddress){
        this(localNick);
        this.remoteAddress = remoteAddress;
    }

    public Caller(String localNick, String ipAddress){
        this.localNick = localNick;
        try {
            this.remoteAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public Connection call(){
        Connection connection = new Connection(remoteAddress,999);
        return connection;
    }

    public String getLocalNick(){
        return localNick;
    }

    InetAddress	getRemoteAddress(){
        return remoteAddress;
    }

    String getRemoteNick(){
        return remoteNick;
    }

    public static enum CallStatus {
        BUSY, NO_SERVICE, NOT_ACCESSIBLE, OK, REJECTED;
    }

    public CallStatus getStatus(){
        return callStatus;
    }

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
