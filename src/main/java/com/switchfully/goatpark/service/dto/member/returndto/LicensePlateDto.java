package com.switchfully.goatpark.service.dto.member.returndto;

public class LicensePlateDto {

    private final int id;
    private final String numberPlate;
    private final String countryCode;

    public LicensePlateDto(int id, String numberPlate, String countryCode) {
        this.id = id;
        this.numberPlate = numberPlate;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
