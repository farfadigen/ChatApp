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
<<<<<<< HEAD
        while(true){
=======
        String l;
        while(flag){
>>>>>>> cf1bd8e9d687968d2de074c0db7d9638d9b55989
            Connection connection = new Connection();
            connection = callListener.getConnection();
            if (connection == null)
                callStatus = Caller.CallStatus.valueOf("BUSY");
            else
                callStatus = Caller.CallStatus.valueOf("OK");
<<<<<<< HEAD
=======

>>>>>>> cf1bd8e9d687968d2de074c0db7d9638d9b55989

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