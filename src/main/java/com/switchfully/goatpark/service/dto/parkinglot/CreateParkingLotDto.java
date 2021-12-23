package com.switchfully.goatpark.service.dto.parkinglot;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.parkinglot.Category;
import com.switchfully.goatpark.service.domain.person.Person;

public class CreateParkingLotDto {

    private String name;
    private Category category;
    private int maximumCapacity;
    private Person contactPerson;
    private Address address;
    private double pricePerHour;

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}