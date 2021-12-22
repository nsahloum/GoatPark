package com.switchfully.goatpark.service.dto.member.returndto;

public class EmailAdresDto {

    private final int id;
    private final String username;
    private final String domain;

    public EmailAdresDto(int id, String username, String domain) {
        this.id = id;
        this.username = username;
        this.domain = domain;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
