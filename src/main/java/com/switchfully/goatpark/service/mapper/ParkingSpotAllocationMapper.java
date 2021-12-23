package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.domain.parkingspotallocation.ParkingSpotAllocation;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.service.dto.parkingallocation.ParkingAllocationDto;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotAllocationMapper {

    public ParkingSpotAllocation mapCreateParkingSpotAllocationToParkingSpotAllocation(Person person, ParkingLot parkinglot) {
        return new ParkingSpotAllocation(person, parkinglot);
    }

    public ParkingAllocationDto mapParkingSpotAllocationToDto(ParkingSpotAllocation parkingSpotAllocation) {
        return new ParkingAllocationDto().setId(parkingSpotAllocation.getId());
    }
}
