package ru.practicum.exceptions;

public class EmailExistsException extends Exception {
    String message;

    public EmailExistsException(String message) {
        super(message);
    }
}
