package com.switchfully.goatpark.service.dto.member;

import javax.persistence.Column;

public class CreateEmailDto {

    private String username;
    private String domain;

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
