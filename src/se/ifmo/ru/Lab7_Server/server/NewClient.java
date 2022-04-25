package se.ifmo.ru.Lab7_Server.server;

import se.ifmo.ru.Commands.Command;
import se.ifmo.ru.data.Ticket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewClient extends Thread {
    private Socket client;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private ObjectInputStream objectInputStream;
    private LinkedList<Ticket> tickets;
    private Runnable executeCommand;
    public NewClient(Socket client,LinkedList<Ticket> tickets){
        this.tickets=tickets;
        this.client=client;
        try {
            outputStream=new DataOutputStream(client.getOutputStream());
            objectInputStream=new ObjectInputStream(client.getInputStream());
            inputStream=new DataInputStream(client.getInputStream());
            start();
        }
        catch (IOException ex){
            System.out.println("Ошибка при инициализации блока ввода-вывода данных");
        }


    }
    @Override
    public void run(){
        Command command;
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            while (true){
                command=(Command) objectInputStream.readObject();
                if(command.getNameOfCommand().equals("exit")) break;
                executeCommand=new ExecuteCommand(outputStream,command,tickets);
                executor.submit(executeCommand);
            }
            System.out.println("Пользователь "+client.getInetAddress()+" отключается");
            outputStream.close();
            objectInputStream.close();
            inputStream.close();
            client.close();


        }
        catch (ClassNotFoundException ex){
            System.out.println("Получен неизвестный объект");
        }
        catch (IOException ex){
            System.out.println("Произошёл разрыв соединения с пользователем");
        }
        finally {
            try {
                client.close();
            }
            catch (IOException ex){
                System.out.println("Сокет не закрыт");
            }
        }



    }
}
