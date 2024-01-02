package ru.netology.jdata424.exeption;

public class NoPersonException extends RuntimeException{
    public NoPersonException() {
        super("Такого человека нет в базе данных");
    }
}
