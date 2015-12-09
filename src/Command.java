/**
 * Created by Маша on 01.11.2015.
 */

public class Command {

    protected String command;
    protected boolean isHaveFalseCommand=false;

    public Command() {

    }

    public void setCommand(String comand) {
        if(comand.toUpperCase().equals("ACCEPTED")){
            this.command="ACCEPTED";
        }
        else if(comand.toUpperCase().equals("REJECTED")){
            this.command="REJECTED";
        }
        else if(comand.toUpperCase().equals("DISCONNECT")){
            this.command="DISCONNECT";
        }
        else{
            isHaveFalseCommand=true;
        }
    }

    public String getCommand(){
        isHaveFalseCommand = true;
        return command;
    }

    public boolean isHaveFalseCommand(){
        return isHaveFalseCommand;
    }
}
