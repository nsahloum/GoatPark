package com.switchfully.goatpark.domain.person;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.phonenumber.PhoneNumber;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "FK_PHONENUMBER")
    @ManyToOne
    private PhoneNumber phoneNumber;

    @JoinColumn(name = "FK_MOBILENUMBER")
    @ManyToOne
    private PhoneNumber mobileNumber;

    @JoinColumn(name = "FK_EMAILADDRESS")
    @OneToOne
    private EmailAddress emailAddress;

    @JoinColumn(name = "FK_ADDRESS")
    @ManyToOne
    private Address address;

    public Person(String name, PhoneNumber phoneNumber, PhoneNumber mobileNumber, EmailAddress emailAddress, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    protected Person() {
    }
}
