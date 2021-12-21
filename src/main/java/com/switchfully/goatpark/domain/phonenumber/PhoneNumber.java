package com.switchfully.goatpark.domain.phonenumber;

import javax.persistence.*;

@Entity
@Table(name = "PHONENUMBER")
public class PhoneNumber {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "PREFIX")
    private String prefix;

    @Column(name = "NUMBER")
    private String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public PhoneNumber() {
    }
}
