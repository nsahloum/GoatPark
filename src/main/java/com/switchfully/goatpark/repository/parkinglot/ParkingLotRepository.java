package com.switchfully.goatpark.repository.parkinglot;

import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.exception.ParkingLotNotFoundException;
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
        String sql = "select p " +
                "from ParkingLot p";
        return entityManager.createQuery(sql, ParkingLot.class)
                .getResultList();
    }

    public ParkingLot getParkingLotById(int parkingLotId) {
        String sql = "SELECT p " +
                "FROM ParkingLot p " +
                "WHERE p.id = :id";
        return entityManager.createQuery(sql, ParkingLot.class)
                .setParameter("id", parkingLotId)
                .getResultList().stream()
                .findFirst()
                .orElseThrow(() -> new ParkingLotNotFoundException("This lot doenst exist"));

    }
}