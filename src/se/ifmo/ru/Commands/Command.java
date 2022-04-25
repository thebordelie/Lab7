package se.ifmo.ru.Commands;
import se.ifmo.ru.data.*;

import java.io.Serializable;
import java.util.LinkedList;

public class Command implements Serializable {
    private Long arg;
    private Ticket ticket;
    private final String nameOfCommand;
    public Command(String nameOfCommand){
        this.nameOfCommand=nameOfCommand;
    }
    public String infoOfCommand(){return "";}
    public String executeCommand(LinkedList<Ticket> tickets){return "";}
    public String getNameOfCommand(){
        return nameOfCommand;
    }
    @Override
    public String toString(){
        return "Команда "+nameOfCommand+", предназначена для работы с коллекцией";
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getArg() {
        return arg;
    }

    public void setArg(Long arg) {
        this.arg = arg;
    }
}
