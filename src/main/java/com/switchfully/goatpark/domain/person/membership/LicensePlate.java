package com.switchfully.goatpark.domain.person.membership;

import javax.persistence.*;

@Entity
@Table(name = "license_plate")
public class LicensePlate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_plate")
    private String numberPlate;

    @Column(name = "country_code")
    private String countryCode;

    protected LicensePlate(){}

    public LicensePlate(String numberPlate, String countryCode) {
        this.numberPlate = numberPlate;
        this.countryCode = countryCode;
    }

    public int getLicenseId() {
        return id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
