package com.switchfully.goatpark.service.dto.member.returndto;

public class PhoneNumberDto {

    private final int id;
    private final String prefix;
    private final String number;

    public PhoneNumberDto(int id, String prefix, String number) {
        this.id = id;
        this.prefix = prefix;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }
}
