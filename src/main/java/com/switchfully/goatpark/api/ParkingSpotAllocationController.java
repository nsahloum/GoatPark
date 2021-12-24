package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.ParkingSpotAllocationService;
import com.switchfully.goatpark.service.dto.parkingallocation.CreateParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkingallocation.ParkingAllocationDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/parking-allocations", produces = APPLICATION_JSON_VALUE)
public class ParkingSpotAllocationController {

    private final ParkingSpotAllocationService parkingSpotAllocationService;

    public ParkingSpotAllocationController(ParkingSpotAllocationService parkingSpotAllocationService) {
        this.parkingSpotAllocationService = parkingSpotAllocationService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('CREATE_PARKING_SPOT_ALLOCATION')")
    public ParkingAllocationDto createParkingSpotAllocation(@RequestBody CreateParkingAllocationDto createParkingAllocation) {
        return parkingSpotAllocationService.createParkingAllocation(createParkingAllocation);
    }
}
