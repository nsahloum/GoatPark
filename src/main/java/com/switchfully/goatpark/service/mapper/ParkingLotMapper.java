package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotOverviewDto;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    public ParkingLot mapCreateParkingLotDtoToParkingLot(CreateParkingLotDto createParkingLotDto) {
        return ParkingLot.ParkingLotBuilder
                .parkingLotBuilder()
                .withName(createParkingLotDto.getName())
                .withCategory(createParkingLotDto.getCategory())
                .withAddress(createParkingLotDto.getAddress())
                .withContactPerson(createParkingLotDto.getContactPerson())
                .withMaximumCapacity(createParkingLotDto.getMaximumCapacity())
                .withPricePerHour(createParkingLotDto.getPricePerHour())
                .build();
    }


    public ParkingLotDto mapParkingLotToParkingLotDto(ParkingLot parkingLot) {
        return new ParkingLotDto()
                .setId(parkingLot.getId())
                .setName(parkingLot.getName())
                .setCategory(parkingLot.getCategory())
                .setAddress(parkingLot.getAddress())
                .setContactPerson(parkingLot.getContactPerson())
                .setMaximumCapacity(parkingLot.getMaximumCapacity())
                .setPricePerHour(parkingLot.getPricePerHour());
    }

    public ParkingLotOverviewDto mapParkingLotToParkingLotOverviewDto(ParkingLot parkingLot) {
        return new ParkingLotOverviewDto()
                .setId(parkingLot.getId())
                .setName(parkingLot.getName())
                .setMaximumCapacity(parkingLot.getMaximumCapacity())
                .setContactPersonEmail(parkingLot.getContactPerson().getEmailAddress())
                .setContactPersonPhoneNumber(parkingLot.getContactPerson().getPhoneNumber());
    }
}