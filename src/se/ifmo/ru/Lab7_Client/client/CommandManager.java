package se.ifmo.ru.Lab7_Client.client;

import se.ifmo.ru.Commands.CommandRegister;
import se.ifmo.ru.Commands.CommandsForCollection.*;
import se.ifmo.ru.data.Ticket;
import se.ifmo.ru.data.Venue;
import se.ifmo.ru.utility.*;

import java.time.LocalDate;
import java.util.Scanner;

public class CommandManager {
    private final SendCommand sendCommand;
    private CommandRegister commandRegister;
    private TicketAsker ticketAsker;
    public CommandManager() {
        ticketAsker=new TicketAsker(new Scanner(System.in));
        this.sendCommand = new SendCommand();
        commandRegister=new CommandRegister();
        commandRegister.registerNewCommand("add",new Add("add"));
        commandRegister.registerNewCommand("add_if_min",new AddIfMin("add_if_min"));
        commandRegister.registerNewCommand("clear",new Clear("clear"));
        commandRegister.registerNewCommand("count_less_than_refundable", new CountLessThanRefundable("count_less_than_refundable"));
        commandRegister.registerNewCommand("execute_script",new ExecuteScript("execute_script"));
        commandRegister.registerNewCommand("group_counting_by_type",new GroupCountingType("group_counting_by_type"));
        commandRegister.registerNewCommand("head",new Head("head"));
        commandRegister.registerNewCommand("help",new Help("help"));
        commandRegister.registerNewCommand("info",new Info("info"));
        commandRegister.registerNewCommand("remove_by_id",new Remove("remove_by_id"));
        commandRegister.registerNewCommand("remove_any_by_venue",new RemoveAnyByVenue("remove_any_by_venue"));
        commandRegister.registerNewCommand("remove_head",new RemoveHead("remove_head"));
        commandRegister.registerNewCommand("show",new Show("show"));
        commandRegister.registerNewCommand("update",new Update("update"));
        commandRegister.registerNewCommand("exit",new Exit("exit"));
    }

    public void processingCommand(String[] finaUserCommand){
        /*
        Засунуть обработку команды в отедльный класс(подумать)
         */
        if(finaUserCommand[0].equals("add")){
            System.out.println("Введите параметры добавляемого билета ");
            Ticket ticket;
            if(commandRegister.getCommands().get("add").getTicket()==null){
                long id=0;
                ticket=new Ticket(id,ticketAsker.askName(),ticketAsker.askCoordinates(), LocalDate.now(),ticketAsker.askPrice(), ticketAsker.askRefundable(), ticketAsker.askTicketType(),new Venue(id, ticketAsker.askName(), ticketAsker.askCapacity(), ticketAsker.askAddress()));
            }
            else {
                long id=commandRegister.getCommands().get("add").getTicket().getId()+1;
                ticket=new Ticket(id,ticketAsker.askName(),ticketAsker.askCoordinates(), LocalDate.now(),ticketAsker.askPrice(), ticketAsker.askRefundable(), ticketAsker.askTicketType(),new Venue(id, ticketAsker.askName(), ticketAsker.askCapacity(), ticketAsker.askAddress()));

            }
            commandRegister.getCommands().get("add").setTicket(ticket);
        }
        if(commandRegister.getCommands().containsKey(finaUserCommand[0])){
            sendCommand.sendingCommand(commandRegister.getCommands().get(finaUserCommand[0]));
        }

        else System.out.println("Команда не найдена, напишите 'help' для получения списка возможных команд");
    }
}
