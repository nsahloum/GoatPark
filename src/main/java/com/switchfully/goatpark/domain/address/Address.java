package com.switchfully.goatpark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "streetName")
    private String streetName;

    @Column(name = "streetNumber")
    private String streetNumber;

    @ManyToOne
    @JoinColumn(name = "FK_POSTALCODE")
    private PostalCode postalCode;

    public Address(String streetName, String streetNumber, PostalCode postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    protected Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}
