/**
 * Created by Маша on 01.11.2015.
 */

public class Command {

    private CommandType ChatCommand;

    public Command(CommandType commandType) {
        this.ChatCommand = commandType;
    }


    @Override
    public String toString() {
        return "Command{" +
                "ChatCommand=" + ChatCommand +
                '}';
    }

    public static enum CommandType {
        ACCEPT, DISCONNECT, MESSAGE, NICK, REJECT;

        public static boolean trueCommand(String test) {

            for (CommandType c : CommandType.values()) {
                if (c.name().equals(test)) {
                    return true;
                }
            }

            return false;
        }
    }


    public static Command getCommand(String string) {
        if (string.contains("Accepted")) return new Command(CommandType.ACCEPT);
        if (string.contains("Disconnect")) return new Command(CommandType.DISCONNECT);
        if (string.contains("Message")) return new Command(CommandType.MESSAGE);
        if (string.contains("Reject")) return new Command(CommandType.REJECT);


        return null;
    }


}
