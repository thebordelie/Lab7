package se.ifmo.ru.Commands.CommandsForCollection;

import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Help extends Command {
    private HashMap<String,Command> commands;
    public Help(String nameOfCommand) {
        super(nameOfCommand);
    }
    @Override
    public String executeCommand(LinkedList<Ticket> ticket){
        String ans = "";
        for(Map.Entry<String, Command> entry:commands.entrySet() ){
            String key=entry.getKey();
            String value=entry.getValue().infoOfCommand();
            ans+=key+": "+value+"\n";
        }
        return ans;
    }

    @Override
    public String infoOfCommand(){
        return "Выводит список команд";
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
