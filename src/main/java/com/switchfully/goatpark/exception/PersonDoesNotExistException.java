package com.switchfully.goatpark.exception;

public class PersonDoesNotExistException extends RuntimeException {
    public PersonDoesNotExistException() {
    }

    public PersonDoesNotExistException(String message) {
        super(message);
    }
}
