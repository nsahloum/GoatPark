package com.switchfully.goatpark.domain.membership;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

//@Entity
//@Table(name = "membership")
public class Membership {
    @Id
    @GeneratedValue
    private int membershipId;
    @Column(name = "registrationDate", columnDefinition = "DATE")
    private LocalDate registrationDate;
}
