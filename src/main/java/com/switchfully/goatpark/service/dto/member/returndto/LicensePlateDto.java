package com.switchfully.goatpark.service.dto.member.returndto;

public class LicensePlateDto {

    private final String numberPlate;
    private final String countryCode;

    public LicensePlateDto(String numberPlate, String countryCode) {
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
