package com.switchfully.goatpark.service.dto.member.returndto;

import java.time.LocalDate;

public class MembershipDto {

    private final LocalDate registrationDate;
    private final String licensePlate;


    public MembershipDto(LocalDate registrationDate, String licensePlate) {
        this.registrationDate = registrationDate;
        this.licensePlate = licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
