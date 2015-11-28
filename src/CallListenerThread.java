import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Created by Маша on 10.11.2015.
 */

public class CallListenerThread extends Observable implements Runnable {
    private CallListener callListener;
    private  boolean flag;
    private Caller.CallStatus callStatus;


    public CallListenerThread() throws IOException{
        callListener = new CallListener();
        start();
    }
    public CallListenerThread(String localNick) throws IOException{
        callListener = new CallListener(localNick);
        start();
    }

    public void run() {
        String l;
        while(flag){
            Connection connection = new Connection();
            connection = callListener.getConnection();
            if (connection == null)
                callStatus = Caller.CallStatus.valueOf("BUSY");
            else
                callStatus = Caller.CallStatus.valueOf("OK");


        }

    }
    public void setBusy(boolean busy){
        callListener.setBusy(busy);
    }

    public void setLocalNick(String localNick){
        callListener.setLocalNick(localNick);
    }
    public void start(){
        this.flag=true;
        run();
    };
    public void stop(){
        this.flag=false;
    };
}