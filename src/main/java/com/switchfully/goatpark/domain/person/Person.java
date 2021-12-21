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
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "FK_PHONENUMBER")
    private PhoneNumber phoneNumber;

    @JoinColumn(name = "FK_MOBILENUMBER")
    private PhoneNumber mobileNumber;

    @JoinColumn(name = "FK_EMAILADDRESS")
    private EmailAddress emailAddress;

    @JoinColumn(name = "FK_ADDRESS")
    private Address address;

    public Person(String name, PhoneNumber phoneNumber, PhoneNumber mobileNumber, EmailAddress emailAddress, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public Person() {
    }
}
