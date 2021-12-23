package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.ParkingLotService;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
@RestController
@RequestMapping(path = "/parkinglots", produces = APPLICATION_JSON)
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    @PostMapping(consumes = APPLICATION_JSON)
    @PreAuthorize("hasAnyAuthority('CREATE_PARKING_LOT')")
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto parkingLotToCreate) {
        return parkingLotService.createParkingLot(parkingLotToCreate);
    }
}
