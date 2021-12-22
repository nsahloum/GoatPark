package com.switchfully.goatpark.service.dto.member.returndto;

import java.time.LocalDate;

public class MembershipDto {
    private final int id;
    private final LocalDate registrationDate;
    private final LicensePlateDto licensePlate;

    public MembershipDto(int id, LocalDate registrationDate, LicensePlateDto licensePlate) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.licensePlate = licensePlate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }
}
