package com.switchfully.goatpark.service.dto.member.returndto;

public class PhoneNumberDto {

    private final String prefix;
    private final String number;

    public PhoneNumberDto(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    private boolean assertNotNull(String prefix) {
        return false;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

}
