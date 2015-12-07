import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Created by Маша on 10.11.2015.
 */

public class CallListenerThread extends Observable implements Runnable {
    private Thread t = null;
    private boolean isWork= true;
    private CallListener callListener;
    private Socket socket;
    public final static  String itIsCallLisnenerThread="socket";


    public CallListenerThread( int port){
        try {
            ServerSocket server = new ServerSocket(port);
            callListener = new CallListener(server);
        } catch (Exception e) {
            System.out.println(  port);
        }
    }

    public void CallListenerStart(String name){
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        while(isWork){
            synchronized (this) {
                socket = null;
                socket = callListener.getSocket();
                setChanged();
                notifyObservers(itIsCallLisnenerThread);
            }
        }
    }


    public void stop(){
        synchronized (this) {
            isWork = false;
        }
    }

    public Socket getSocket(){
        Socket socket1 = socket;
        return socket1;
    }



}