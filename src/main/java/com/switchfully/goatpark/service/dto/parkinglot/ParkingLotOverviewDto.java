package com.switchfully.goatpark.service.dto.parkinglot;

import com.switchfully.goatpark.service.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;

public class ParkingLotOverviewDto {

    private int id;
    private String name;
    private int maximum_capacity;
    private EmailAddress contactPersonEmail;
    private PhoneNumber contactPersonPhoneNumber;

    public int getId() {
        return id;
    }

    public ParkingLotOverviewDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkingLotOverviewDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getMaximum_capacity() {
        return maximum_capacity;
    }

    public ParkingLotOverviewDto setMaximum_capacity(int maximum_capacity) {
        this.maximum_capacity = maximum_capacity;
        return this;
    }

    public EmailAddress getContactPersonEmail() {
        return contactPersonEmail;
    }

    public ParkingLotOverviewDto setContactPersonEmail(EmailAddress contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
        return this;
    }

    public PhoneNumber getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public ParkingLotOverviewDto setContactPersonPhoneNumber(PhoneNumber contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        return this;
    }
}
