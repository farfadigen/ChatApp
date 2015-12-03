import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * Created by Маша on 03.12.2015.
 */


public class HistoryModel extends Observable {

    class Message{

        private String text,nick;
        private Date date;

        Message(String nick,Date date,String text){
            this.nick=nick;
            this.date=date;
            this.text=text;
        }

        String getNick(){
            return nick;
        }

        String getText(){
            return text;
        }

        Date getDate(){
            return date;
        }
    }

    private List<Message> messages;

    HistoryModel (){
        messages = new ArrayList<Message>();
    }

    void addMessage(HistoryModel.Message model){
        messages.add(model);
        setChanged();
        notifyObservers();
    }

    void addMessage(String nick,Date date,String text){
        HistoryModel.Message m=new HistoryModel.Message(nick,date,text);
        messages.add(m);
        setChanged();
        notifyObservers();
    }

    void clear(){
        messages.clear();
        setChanged();
        notifyObservers();
    }

    HistoryModel.Message getMessage(int pos){
        return messages.get(pos);
    }

    int getSize(){
        return messages.size();
    }

}
