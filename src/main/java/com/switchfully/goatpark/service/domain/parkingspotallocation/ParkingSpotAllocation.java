package com.switchfully.goatpark.service.domain.parkingspotallocation;

import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.service.domain.person.Person;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PARKING_SPOT_ALLOCATION")
public class ParkingSpotAllocation {

    @Id
    @GeneratedValue(generator = "parking_spot_allocation_seq")
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_PERSON_ID")
    // For getting the member id and license plate number
    private Person member;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_PARKING_LOT_ID")
    private ParkingLot parkingLot;

    @Column(name = "START_DATE_TIME")
    private LocalDateTime startDateTime = LocalDateTime.now();

    private ParkingSpotAllocation() {
     }

    public ParkingSpotAllocation(Person member, ParkingLot parkingLotId) {
        this.member = member;
        this.parkingLot = parkingLotId;
        this.startDateTime = startDateTime;
    }

    public ParkingSpotAllocation setMember(Person member) {
        this.member = member;
        return this;
    }

    public ParkingSpotAllocation setParkingLot(ParkingLot parkingLotId) {
        this.parkingLot = parkingLotId;
        return this;
    }

    public ParkingSpotAllocation setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public int getId() {
        return id;
    }

    public Person getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
