package com.switchfully.goatpark.service.dto.parkinglot;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.parkinglot.Category;
import com.switchfully.goatpark.domain.person.Person;

public class CreateParkingLotDto {

    private final String name;
    private final Category category;
    private final int maximumCapacity;
    private final Person contactPerson;
    private final Address address;
    private final double pricePerHour;

    public CreateParkingLotDto(String name, Category category, int maximumCapacity, Person contactPerson, Address address, double pricePerHour) {
        this.name = name;
        this.category = category;
        this.maximumCapacity = maximumCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

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