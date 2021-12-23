package com.switchfully.goatpark.domain.person.phonenumber;

import javax.persistence.*;

@Entity
@Table(name = "PHONE_NUMBER")
public class PhoneNumber {

    private static final int PREFIX_MAX_LENGTH = 4;

    @Id
    @GeneratedValue(generator = "phone_number_seq")
    private int id;

    @Column(name = "PREFIX")
    private String prefix;

    @Column(name = "NUMBER")
    private String number;


    public PhoneNumber(String prefix, String number) {

        this.prefix = checkValidPrefix(prefix);
        this.number = number;
    }

    protected PhoneNumber() {
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

    private String checkValidPrefix(String prefix) {
        if (prefix.length() > PREFIX_MAX_LENGTH) throw new IllegalArgumentException("Prefix is " + PREFIX_MAX_LENGTH + " digits maximum");
        return prefix;
    }
}
