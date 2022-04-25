package se.ifmo.ru.Commands.CommandsForCollection;
import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CountLessThanRefundable extends Command {
    private boolean refundable;
    public CountLessThanRefundable(String nameOfCommand) {
        super(nameOfCommand);
    }
    @Override
    public String executeCommand(LinkedList<Ticket> tickets){
        try {
            int count=0;
            if(refundable){
                for(Ticket ticket:tickets){
                    if(!ticket.isRefundable()){
                        count+=1;
                    }
                }

            }
            return"Количество элементов="+tickets.size();
        }
        catch (NoSuchElementException ex){
            return "Коллекция пуста";
        }
        catch (NumberFormatException ex){
            return "Сравнение невозможно!";
        }
    }
    @Override
    public String infoOfCommand(){
        return "Выводит количество элементов, значение refundable которых меньше заданного";
    }
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }
}
