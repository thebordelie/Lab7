package se.ifmo.ru.Lab7_Client.client;

import se.ifmo.ru.Commands.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendCommand {
    private final int PORT=8090;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    public SendCommand(){
        newConnection(0);
    }
    public void sendingCommand(Command command){
        try {
            objectOutputStream.writeObject(command);
            outputStream.flush();
            if(command.getNameOfCommand().equals("exit")){
                System.out.println("Отключение программы");
                System.exit(1);}
            System.out.println(inputStream.readUTF());

        }
        catch (IOException ex){
            System.out.println("Ошибка подсоединения к серверу");
            newConnection(5000);
        }
        catch (NullPointerException exception){
            newConnection(5000);
        }
    }
    public void newConnection(int sleepTime){
        System.out.println("Попытка подключиться к серверу");
        try {
            Thread.sleep(sleepTime);
            socket=new Socket("localhost",PORT);
            inputStream=new DataInputStream(socket.getInputStream());
            outputStream=new DataOutputStream(socket.getOutputStream());
            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Подключение произошло успешно");
        }
        catch (InterruptedException ex){
            System.out.println("Ошибка прерывания");
        }
        catch (UnknownHostException ex){
            System.out.println("Неизвестный хост");
            System.exit(1);
        }
        catch (IOException ex){
            System.out.println("Ошибка при соединении с сервером");
            newConnection(5000);
        }

    }
}
