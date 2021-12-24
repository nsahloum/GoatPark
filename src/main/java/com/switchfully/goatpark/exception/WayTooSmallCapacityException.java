package com.switchfully.goatpark.exception;

public class WayTooSmallCapacityException extends RuntimeException {
    public WayTooSmallCapacityException(String message) {
        super(message);
    }
}
