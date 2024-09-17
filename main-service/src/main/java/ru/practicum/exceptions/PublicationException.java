package ru.practicum.exceptions;

public class PublicationException extends Exception {

    String message;

    public PublicationException(String message) {
        super(message);
    }
}
