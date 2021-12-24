package com.switchfully.goatpark.exception;

public class PhoneNumberIsRequiredException extends RuntimeException {

    public PhoneNumberIsRequiredException(String message) {
        super(message);
    }
}
