package com.switchfully.goatpark.repository.parkinglot;

import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ParkingLotRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public ParkingLot save(ParkingLot parkingLotToSave) {
        entityManager.persist(parkingLotToSave);
        return parkingLotToSave;
    }
}