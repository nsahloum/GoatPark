package com.switchfully.goatpark.service.domain.parkinglot;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "maximum_capacity")
    private int maximumCapacity;

    @JoinColumn(name = "fk_person_id")
    @ManyToOne
    private Person contactPerson;

    @JoinColumn(name = "fk_address_id")
    @OneToOne
    private Address address;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    private ParkingLot() {
    }

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

    public static class ParkingLotBuilder {
        private String name;
        private Category category;
        private int maximumCapacity;
        private Person contactPerson;
        private Address address;
        private double pricePerHour;

        private ParkingLotBuilder() {
        }

        public static ParkingLotBuilder parkingLotBuilder() {
            return new ParkingLotBuilder();
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }

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
