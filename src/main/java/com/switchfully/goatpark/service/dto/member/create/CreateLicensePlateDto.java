package com.switchfully.goatpark.service.dto.member.create;

public class CreateLicensePlateDto {

    private final String numberPlate;
    private final String countryCode;

    public CreateLicensePlateDto(String numberPlate, String countryCode) {
        this.numberPlate = numberPlate;
        this.countryCode = countryCode;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
