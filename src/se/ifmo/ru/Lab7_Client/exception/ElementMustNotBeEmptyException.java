package se.ifmo.ru.Lab7_Client.exception;

public class ElementMustNotBeEmptyException extends Exception{
    public ElementMustNotBeEmptyException(){
        super("Элемент не может быть пустым");
    }
}
