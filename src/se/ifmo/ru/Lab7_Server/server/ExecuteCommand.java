package se.ifmo.ru.Lab7_Server.server;

import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.Ticket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecuteCommand implements Runnable {
    private DataOutputStream outputStream;
    private Command command;
    private LinkedList<Ticket> tickets;
    public ExecuteCommand(DataOutputStream outputStream, Command command,LinkedList<Ticket> tickets) {
        this.outputStream = outputStream;
        this.command = command;
        this.tickets=tickets;
    }

    @Override
    public void run(){
        String answerOfCommand;
        Lock lock=new ReentrantLock();
        lock.lock();
        answerOfCommand=command.executeCommand(tickets);
        try {
            lock.unlock();
            outputStream.writeUTF(answerOfCommand);
            outputStream.flush();
        }
        catch (IOException ex){
            System.out.println("Ошибка при отправлении данных");
        }
    }
}
