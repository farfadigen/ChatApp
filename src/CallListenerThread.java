import java.io.IOException;
import java.util.Observable;

/**
 * Created by Маша on 10.11.2015.
 */

public class CallListenerThread extends Observable implements Runnable {
    private CallListener callListener;
    private  boolean flag;


    public CallListenerThread() throws IOException{
        callListener = new CallListener();
        start();
    }
    public CallListenerThread(String localNick) throws IOException{
        callListener = new CallListener(localNick);
        start();
    }

    public void run() {
        while(true){
            try{
                Connection connection = callListener.getConnection();
                if (connection == null)
                    callStatus = Caller.CallStatus.valueOf("BUSY");
                else
                    callStatus = Caller.CallStatus.valueOf("OK");

            }catch(IOException e){
                System.out.println("error");
            }

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