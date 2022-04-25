package se.ifmo.ru.Lab7_Client;

import se.ifmo.ru.Lab7_Client.client.ConsoleManager;
public class Start {
    public static void main(String[] args){
        System.out.println("Запуск программы");
        ConsoleManager consoleManager=new ConsoleManager();
        consoleManager.interactiveMod();
    }
}
