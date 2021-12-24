package com.switchfully.goatpark.domain.person.membership;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue(generator = "membership_seq")
    private int id;

    @Column(name = "registration_date", columnDefinition = "DATE")
    private LocalDate registrationDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_license_plate_id")
    private LicensePlate licensePlate;

    protected Membership() {
    }

    public Membership(LicensePlate licensePlate) {
        this.registrationDate = LocalDate.now();
        this.licensePlate = licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }
}
