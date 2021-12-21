package com.switchfully.goatpark.service.dto.member;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;

public class CreateMemberDto {

    private String username;
    private String password;

    private String name;
    private Address address;
    private PhoneNumber phoneNumber;
    private PhoneNumber mobileNumber;
    private EmailAddress emailAddress;
    private LicensePlate licensePlate;

    public CreateMemberDto(String name, Address address, PhoneNumber phoneNumber, PhoneNumber mobileNumber, EmailAddress emailAddress, LicensePlate licensePlate) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
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

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }
}
