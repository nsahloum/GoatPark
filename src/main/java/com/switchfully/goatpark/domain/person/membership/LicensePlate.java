package com.switchfully.goatpark.domain.person.membership;

import javax.persistence.*;

@Entity
@Table(name = "license_plate")
public class LicensePlate {
    @Id
    @GeneratedValue
    private int licenseId;
    @Column(name = "numberPlate")
    private String numberPlate;
    @Column(name = "countryCode")
    private String countryCode;

    protected LicensePlate(){}

    public LicensePlate(String numberPlate, String countryCode) {
        this.numberPlate = numberPlate;
        this.countryCode = countryCode;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
