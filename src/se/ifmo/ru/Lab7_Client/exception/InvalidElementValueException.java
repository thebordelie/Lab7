package se.ifmo.ru.Lab7_Client.exception;

public class InvalidElementValueException extends Exception{
    public InvalidElementValueException(){
        super("Элемент не удовлетворяет условиям");
    }
}
