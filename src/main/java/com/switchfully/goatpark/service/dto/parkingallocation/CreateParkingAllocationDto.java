package com.switchfully.goatpark.service.dto.parkingallocation;

public class CreateParkingAllocationDto {

    private final int personId;
    private final int parkingLotId;

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
