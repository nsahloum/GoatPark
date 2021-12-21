package com.switchfully.goatpark.domain.phonenumber;

import javax.persistence.*;

@Entity
@Table(name = "PHONENUMBER")
public class PhoneNumber {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "PREFIX")
    private String prefix;

    @Column(name = "NUMBER")
    private String number;

    private final int PREFIXMAXLENGHT = 4;

    public PhoneNumber(String prefix, String number) {

        this.prefix = checkValidPrefix(prefix);
        this.number = number;
    }

    protected PhoneNumber() {
    }

    private String checkValidPrefix(String prefix) {
        if (prefix.length() > PREFIXMAXLENGHT) throw new IllegalArgumentException("Prefix is " + PREFIXMAXLENGHT + " digits maximum");
        return prefix;
    }
}
