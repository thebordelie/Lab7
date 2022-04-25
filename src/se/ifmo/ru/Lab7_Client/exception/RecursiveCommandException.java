package se.ifmo.ru.Lab7_Client.exception;

public class RecursiveCommandException extends Exception{
    public RecursiveCommandException(){
        super("Команда вызывается рекурсивно - выполнение скрипта будет бесконечным");
    }
}
