package com.switchfully.goatpark.service.dto.member.returndto;

public class EmailAddressDto {

    private final String username;
    private final String domain;

    public EmailAddressDto(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }
}
