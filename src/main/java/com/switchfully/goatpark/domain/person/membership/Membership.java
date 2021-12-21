package com.switchfully.goatpark.domain.person.membership;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue
    private int membershipId;
    @Column(name = "registrationDate", columnDefinition = "DATE")
    private LocalDate registrationDate;
    @OneToOne
    @JoinColumn(name = "fk_license_plate_id")
    private LicensePlate licensePlate;

    protected Membership() {}

    public Membership(LocalDate registrationDate, LicensePlate licensePlate) {
        this.registrationDate = registrationDate;
        this.licensePlate = licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }
}
