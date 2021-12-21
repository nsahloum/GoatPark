package com.switchfully.goatpark.domain.address;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

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

    public Address() {
    }
}
