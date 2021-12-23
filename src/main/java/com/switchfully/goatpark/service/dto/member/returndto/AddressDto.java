package com.switchfully.goatpark.service.dto.member.returndto;

import com.switchfully.goatpark.service.domain.address.PostalCode;

public class AddressDto {

    private final String streetName;
    private final String streetNumber;
    private final PostalCodeDto postalCode;

    public AddressDto(String streetName, String streetNumber, PostalCodeDto postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCodeDto getPostalCode() {
        return postalCode;
    }
}
