/**
 * Created by Маша on 15.11.2015.
 */
public class NickCommand extends Command {
    private boolean isBusy;
    private String nick,version;

    public NickCommand(String version, String nick, boolean busy) {
        super(Command.CommandType.NICK);
        this.isBusy = busy;
        this.nick = nick;
        this.version = version;
    }


    public String toString() {
        return version+ " " + nick + " " +isBusy  + "\n";
    }

    public boolean isBusy() {
        return isBusy;
    }

    public String getNick() {
        return nick;
    }
}