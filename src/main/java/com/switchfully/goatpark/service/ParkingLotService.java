package com.switchfully.goatpark.service;

import com.switchfully.goatpark.repository.parkinglot.ParkingLotRepository;
import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotDto;
import com.switchfully.goatpark.service.mapper.ParkingLotMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingLotMapper parkingLotMapper;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public ParkingLotDto createParkingLot(CreateParkingLotDto parkingLotToCreate) {
        ParkingLot parkingLotToSave = parkingLotMapper.mapCreateParkingLotDtoToParkingLot(parkingLotToCreate);
        parkingLotRepository.save(parkingLotToSave);
        return parkingLotMapper.mapParkingLotToParkingLotDto(parkingLotToSave);
    }
}