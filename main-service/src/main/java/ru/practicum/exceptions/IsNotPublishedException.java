package ru.practicum.exceptions;

public class IsNotPublishedException extends Exception {
    String message;

    public IsNotPublishedException(String message) {
        super(message);
    }
}
