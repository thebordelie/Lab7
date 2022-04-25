package se.ifmo.ru.Lab7_Client.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleManager {
    private final BufferedReader keyboard;
    private final CommandManager commandManager;
    public ConsoleManager(){
        keyboard=new BufferedReader(new InputStreamReader(System.in));
        commandManager=new CommandManager();
    }
    public void interactiveMod(){
        String userCommand;
        String[] finalUserCommand;
        try {
            while (true){
                System.out.print("Выполнить команду: ");
                userCommand=keyboard.readLine();
                finalUserCommand=userCommand.split(" ",2);
                commandManager.processingCommand(finalUserCommand);

            }
        }
        catch (IOException ex){
            System.out.println("Ошибка при считывании");
        }

    }
}
