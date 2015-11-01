/**
 * Created by Маша on 01.11.2015.
 */

public class Command {
    private connector connect = new connector(" ",0);

    public Command() {
    }

    public void disconnect() {
        connect.disconnect();
    }

    public void sendMessage(String message) {
        connect.sendMessage();
        connect.sendMessage();
    }



}
