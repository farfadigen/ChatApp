htlmimport java.net.*;

/**
 * Created by user on 2015-11-08.
 */
public class Caller {
    private String localNick="Unnamed";
    private InetAddress remoteAddress;

    public Caller(){}

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

    public Connection 	call(){
        Connection connection = new Connection(remoteAddress,999);
        return connection;
    }

    public String 	getLocalNick(){
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

    Caller.CallStatus getStatus(){

    }

    void 	setLocalNick(String localNick){
        this.localNick = localNick;
    }

    void 	setRemoteAddress(InetAddress remoteAddress){
        this.remoteAddress = remoteAddress;
    }

    String 	toString(){

    }

    /*static void main(java.lang.String[] args){

    }*/
}
