package se.ifmo.ru.Commands.CommandsForCollection;

import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Remove extends Command {
    private long id;
    public Remove(String nameOfCommand) {
        super(nameOfCommand);
    }
    @Override
    public String executeCommand(LinkedList<Ticket> tickets){
        try {
            for (Ticket ticket:tickets){
                if(ticket.getId()==id){
                    tickets.remove(ticket);
                    return "Элемент удалён";
                }
                if (ticket.equals(tickets.getLast())){
                    return "Элемент не найден";
                }
            }
        }
        catch (NoSuchElementException ex){
            return "Коллекция пуста, удаление невозможно";
        }
        return "";
    }
    @Override
    public String infoOfCommand(){
        return "Удаляет элемент коллекции по заданному id";
    }

    public void setId(long id) {
        this.id = id;
    }
}

