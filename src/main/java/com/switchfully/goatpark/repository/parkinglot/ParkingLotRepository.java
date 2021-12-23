package com.switchfully.goatpark.repository.parkinglot;

import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ParkingLotRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public ParkingLot save(ParkingLot parkingLotToSave) {
        entityManager.persist(parkingLotToSave);
        return parkingLotToSave;
    }

    public List<ParkingLot> getAll() {
        return entityManager.createQuery("select p from ParkingLot p", ParkingLot.class)
                .getResultList();
    }

    public ParkingLot getParkingLotById(int parkingLotId) {
        return entityManager.find(ParkingLot.class, parkingLotId);
    }
}