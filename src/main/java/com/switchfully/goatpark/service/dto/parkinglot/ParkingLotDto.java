package com.switchfully.goatpark.service.dto.parkinglot;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.parkinglot.Category;
import com.switchfully.goatpark.service.domain.person.Person;

public class ParkingLotDto {
    private int id;
    private String name;
    private Category category;
    private int maximumCapacity;
    private Person contactPerson;
    private Address address;
    private double pricePerHour;

    public ParkingLotDto setId(int id) {
        this.id = id;
        return this;
    }

    public ParkingLotDto setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDto setCategory(Category category) {
        this.category = category;
        return this;
    }

    public ParkingLotDto setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        return this;
    }

    public ParkingLotDto setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ParkingLotDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public ParkingLotDto setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public int getId() {
        return id;
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