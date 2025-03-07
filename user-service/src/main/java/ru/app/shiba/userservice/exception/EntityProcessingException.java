package ru.app.shiba.userservice.exception;

public class EntityProcessingException extends RuntimeException {
    public EntityProcessingException(String message) {
        super(message);
    }
}
