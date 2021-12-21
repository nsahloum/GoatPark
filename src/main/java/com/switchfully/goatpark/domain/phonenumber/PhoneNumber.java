package com.switchfully.goatpark.domain.phonenumber;

public class PhoneNumber {
    private final String prefix;
    private final String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }
}
