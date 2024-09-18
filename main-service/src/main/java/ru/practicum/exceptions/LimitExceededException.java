package ru.practicum.exceptions;

public class LimitExceededException extends Exception {

    String message;

    public LimitExceededException(String message) {
        super(message);
    }
}
