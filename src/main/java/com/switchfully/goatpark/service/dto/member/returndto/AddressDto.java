package com.switchfully.goatpark.service.dto.member.returndto;

import com.switchfully.goatpark.domain.address.PostalCode;

public class AddressDto {

    private final int id;
    private final String streetName;
    private final String streetNumber;
    private final PostalCode postalCode;

    public AddressDto(int id, String streetName, String streetNumber, PostalCode postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
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
