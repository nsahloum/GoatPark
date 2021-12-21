package com.switchfully.goatpark.domain.person;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;

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

    @OneToOne
    @JoinColumn(name = "fk_membership_id")
    private Membership membership;

    public Person(String name, PhoneNumber phoneNumber, PhoneNumber mobileNumber, EmailAddress emailAddress, Address address, Membership membership) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.membership = membership;
    }

    protected Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumber getMobileNumber() {
        return mobileNumber;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }
}
