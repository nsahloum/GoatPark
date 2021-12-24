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
    @GeneratedValue(generator = "person_seq")
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "FK_PHONE_NUMBER")
    @ManyToOne(cascade = {CascadeType.ALL})
    private PhoneNumber phoneNumber;

    @JoinColumn(name = "FK_MOBILE_NUMBER")
    @ManyToOne(cascade = {CascadeType.ALL})
    private PhoneNumber mobileNumber;

    @JoinColumn(name = "FK_EMAIL_ADDRESS")
    @OneToOne(cascade = {CascadeType.ALL})
    private EmailAddress emailAddress;

    @JoinColumn(name = "FK_ADDRESS")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Address address;

    @OneToOne(cascade = {CascadeType.ALL})
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

    public Membership getMembership() {
        return membership;
    }

    public static class PersonBuilder {

        private String name;
        private PhoneNumber phoneNumber;
        private PhoneNumber mobileNumber;
        private EmailAddress emailAddress;
        private Address address;
        private Membership membership;

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder withMobileNumber(PhoneNumber mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PersonBuilder withEmailAddress(EmailAddress emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public PersonBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public PersonBuilder withMembership(Membership membership) {
            this.membership = membership;
            return this;
        }

        public Person build() {
            return new Person(name, phoneNumber, mobileNumber, emailAddress, address, membership);
        }
    }
}
