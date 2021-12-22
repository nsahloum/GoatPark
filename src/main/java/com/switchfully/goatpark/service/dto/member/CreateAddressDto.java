package com.switchfully.goatpark.service.dto.member;

import com.switchfully.goatpark.domain.address.PostalCode;

public class CreateAddressDto {

    private String streetName;
    private String streetNumber;
    private CreatePostalCodeDto postalCode;

    public CreateAddressDto(String streetName, String streetNumber, CreatePostalCodeDto postalCode) {
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

    public CreatePostalCodeDto getPostalCode() {
        return postalCode;
    }
}