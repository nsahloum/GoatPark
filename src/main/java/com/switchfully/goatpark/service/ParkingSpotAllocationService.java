package com.switchfully.goatpark.service;

import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.repository.parkingallocation.ParkingSpotAllocationRepository;
import com.switchfully.goatpark.repository.parkinglot.ParkingLotRepository;
import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.domain.parkingspotallocation.ParkingSpotAllocation;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.service.dto.parkingallocation.CreateParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkingallocation.ParkingAllocationDto;
import com.switchfully.goatpark.service.mapper.ParkingSpotAllocationMapper;
import org.springframework.stereotype.Service;

import static com.switchfully.goatpark.service.AssertFieldService.assertParkingAllocationIsValid;

@Service
public class ParkingSpotAllocationService {
    private final ParkingSpotAllocationRepository parkingSpotAllocationRepository;
    private final MemberRepository memberRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingSpotAllocationMapper parkingSpotAllocationMapper;

    public ParkingSpotAllocationService(ParkingSpotAllocationRepository parkingSpotAllocationRepository, MemberRepository memberRepository, ParkingLotRepository parkingLotRepository, ParkingSpotAllocationMapper parkingSpotAllocationMapper) {
        this.parkingSpotAllocationRepository = parkingSpotAllocationRepository;
        this.memberRepository = memberRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotAllocationMapper = parkingSpotAllocationMapper;
    }

    public ParkingAllocationDto createParkingAllocation(CreateParkingAllocationDto createParkingAllocation) {
        assertParkingAllocationIsValid(createParkingAllocation);
        Person person = memberRepository.getMemberById(createParkingAllocation.getPersonId());

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(createParkingAllocation.getParkingLotId());

        ParkingSpotAllocation parkingSpotAllocation = parkingSpotAllocationMapper.mapCreateParkingSpotAllocationToParkingSpotAllocation(person, parkingLot);
        ParkingSpotAllocation savedAllocation = parkingSpotAllocationRepository.save(parkingSpotAllocation);
        return parkingSpotAllocationMapper.mapParkingSpotAllocationToDto(savedAllocation);
    }
}
