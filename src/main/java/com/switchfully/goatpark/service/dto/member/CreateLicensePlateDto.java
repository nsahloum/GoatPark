package com.switchfully.goatpark.service.dto.member;

public class CreateLicensePlateDto {


    private String numberPlate;
    private String countryCode;

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
