package se.ifmo.ru.Commands.CommandsForCollection;

import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.*;

import java.util.LinkedList;

public class AddIfMin extends Command {
    private Ticket ticket;
    public AddIfMin(String nameOfCommand) {
        super(nameOfCommand);
    }
    @Override
    public String executeCommand(LinkedList<Ticket> tickets) {
        if (tickets.size() == 0) {
            tickets.add(ticket);
            return "Коллекция пуста, добавление будет выполнено";

        } else {
            float price;
            price = tickets.get(0).getPrice();
            for (Ticket ticket1 : tickets) {
                if ( ticket1.getPrice()<price) {
                    price = ticket1.getPrice();
                }

            }
            if (ticket.getPrice()<price) {
                tickets.add(ticket);
                return "Элемент успешно добавлен";

            } else return "Элемент не наименьший";

        }
    }
    @Override
    public String infoOfCommand(){
        return "Добавляет в коллекцию новый элемент, если его значение наименьшее";
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
