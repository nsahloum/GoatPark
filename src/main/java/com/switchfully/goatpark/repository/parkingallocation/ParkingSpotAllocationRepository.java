package com.switchfully.goatpark.repository.parkingallocation;

import com.switchfully.goatpark.domain.parkingspotallocation.ParkingSpotAllocation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class ParkingSpotAllocationRepository {

    private final EntityManager manager;

    public ParkingSpotAllocationRepository(EntityManager manager) {
        this.manager = manager;
    }


    @Transactional
    public ParkingSpotAllocation save(ParkingSpotAllocation parkingSpotAllocation) {
        manager.persist(parkingSpotAllocation);
        return parkingSpotAllocation;
    }
}
