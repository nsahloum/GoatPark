package com.switchfully.goatpark.service;

import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.repository.parkingallocation.ParkingSpotAllocationRepository;
import com.switchfully.goatpark.repository.parkinglot.ParkingLotRepository;
import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.service.domain.parkingspotallocation.ParkingSpotAllocation;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.dto.parkingallocation.CreateParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkingallocation.ParkingAllocationDto;
import com.switchfully.goatpark.service.mapper.ParkingSpotAllocationMapper;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotAllocationService {
    private ParkingSpotAllocationRepository parkingSpotAllocationRepository;
    private MemberRepository memberRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotAllocationMapper parkingSpotAllocationMapper;

    public ParkingSpotAllocationService(ParkingSpotAllocationRepository parkingSpotAllocationRepository, MemberRepository memberRepository, ParkingLotRepository parkingLotRepository, ParkingSpotAllocationMapper parkingSpotAllocationMapper) {
        this.parkingSpotAllocationRepository = parkingSpotAllocationRepository;
        this.memberRepository = memberRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotAllocationMapper = parkingSpotAllocationMapper;
    }

    public ParkingAllocationDto createParkingAllocation(CreateParkingAllocationDto createParkingAllocation) {
        Person person = memberRepository.getMemberById(createParkingAllocation.getPersonId());

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(createParkingAllocation.getParkingLotId());

        ParkingSpotAllocation parkingSpotAllocation = parkingSpotAllocationMapper.mapCreateParkingSpotAllocationToParkingSpotAllocation(person, parkingLot);
        ParkingSpotAllocation savedAllocation = parkingSpotAllocationRepository.save(parkingSpotAllocation);
        return parkingSpotAllocationMapper.mapParkingSpotAllocationToDto(savedAllocation);
    }
}
