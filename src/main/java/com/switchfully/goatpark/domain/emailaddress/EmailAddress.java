package com.switchfully.goatpark.domain.emailaddress;

import javax.persistence.*;

@Entity
@Table(name = "EMAILADDRESS")
public class EmailAddress {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "DOMAIN")
    private String domain;

    public EmailAddress(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    public EmailAddress() {
    }
}
