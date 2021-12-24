package com.switchfully.goatpark.service.dto.member.create;

public class CreateEmailDto {

    private final String username;
    private final String domain;

    public CreateEmailDto(String username, String domain) {
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
