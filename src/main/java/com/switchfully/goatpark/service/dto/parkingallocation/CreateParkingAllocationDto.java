package com.switchfully.goatpark.service.dto.parkingallocation;

import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.domain.person.Person;

public class CreateParkingAllocationDto {

    private int personId;
    private int parkingLotId;

    public CreateParkingAllocationDto(int personId, int parkingLotId) {
        this.personId = personId;
        this.parkingLotId = parkingLotId;
    }


    public int getPersonId() {
        return personId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }
}
