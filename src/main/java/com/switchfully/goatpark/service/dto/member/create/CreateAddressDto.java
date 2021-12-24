package com.switchfully.goatpark.service.dto.member.create;

public class CreateAddressDto {

    private final String streetName;
    private final String streetNumber;
    private final CreatePostalCodeDto postalCode;

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