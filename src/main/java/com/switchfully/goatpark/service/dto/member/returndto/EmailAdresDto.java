package com.switchfully.goatpark.service.dto.member.returndto;

public class EmailAdresDto {

    private final String username;
    private final String domain;

    public EmailAdresDto(String username, String domain) {
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
