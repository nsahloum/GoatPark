package com.switchfully.goatpark.domain.parkinglot;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.person.Person;

public class ParkingLot {
    private String name;
    private Category category;
    private int maximumCapacity;
    private Person contactPerson;
    private Address address;
    private double pricePerHour;

    private ParkingLot(ParkingLotBuilder parkingLotBuilder) {
        this.name = parkingLotBuilder.name;
        this.category = parkingLotBuilder.category;
        this.maximumCapacity = parkingLotBuilder.maximumCapacity;
        this.contactPerson = parkingLotBuilder.contactPerson;
        this.address = parkingLotBuilder.address;
        this.pricePerHour = parkingLotBuilder.pricePerHour;
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

    public static class ParkingLotBuilder{
        private String name;
        private Category category;
        private int maximumCapacity;
        private Person contactPerson;
        private Address address;
        private double pricePerHour;

        private ParkingLotBuilder(){}

        public static ParkingLotBuilder parkingLotBuilder () {
            return new ParkingLotBuilder();
        }

        public ParkingLot build() {return new ParkingLot(this);}

        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public ParkingLotBuilder withMaximumCapacity(int maximumCapacity) {
            this.maximumCapacity = maximumCapacity;
            return this;
        }

        public ParkingLotBuilder withContactPerson(Person contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public ParkingLotBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ParkingLotBuilder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }
    }
}
