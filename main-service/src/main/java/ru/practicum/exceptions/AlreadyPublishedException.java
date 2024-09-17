package ru.practicum.exceptions;

public class AlreadyPublishedException extends Exception {

    String message;

    public AlreadyPublishedException(String message) {
        super(message);
    }
}
