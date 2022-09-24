package ru.netology.javaqa;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String msg) {
        super(msg);
    }
}
