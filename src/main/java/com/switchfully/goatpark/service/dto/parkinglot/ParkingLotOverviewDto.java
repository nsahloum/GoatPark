package com.switchfully.goatpark.service.dto.parkinglot;

import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;

import java.util.Objects;

public class ParkingLotOverviewDto {

    private int id;
    private String name;
    private int maximumCapacity;
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

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public ParkingLotOverviewDto setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotOverviewDto that = (ParkingLotOverviewDto) o;
        return id == that.id && maximumCapacity == that.maximumCapacity && Objects.equals(name, that.name) && Objects.equals(contactPersonEmail, that.contactPersonEmail) && Objects.equals(contactPersonPhoneNumber, that.contactPersonPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maximumCapacity, contactPersonEmail, contactPersonPhoneNumber);
    }
}
