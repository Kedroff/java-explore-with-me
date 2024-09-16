package ru.practicum.exceptions;

public class PatchException extends Exception {
    String message;

    public PatchException(String message) {
        super(message);
    }
}
