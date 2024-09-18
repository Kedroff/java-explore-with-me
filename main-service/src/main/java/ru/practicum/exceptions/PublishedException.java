package ru.practicum.exceptions;

public class PublishedException extends Exception {

    String message;

    public PublishedException(String message) {
        super(message);
    }
}
