package com.switchfully.goatpark.domain.contactperson;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.phonenumber.PhoneNumber;

public class ContactPerson {

    private final String name;
    private final PhoneNumber phoneNumber;
    private final PhoneNumber mobileNumber;
    private final EmailAddress emailAddress;
    private final Address address;

    public ContactPerson(String name, PhoneNumber phoneNumber, PhoneNumber mobileNumber, EmailAddress emailAddress, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }
}
