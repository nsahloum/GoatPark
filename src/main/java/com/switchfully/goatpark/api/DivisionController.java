package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.division.DivisionService;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/divisions", produces = APPLICATION_JSON_VALUE)
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CREATE_DIVISION')")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDto createDivision(@RequestBody CreateDivisionDto divisionToCreate) {
        return divisionService.createDivision(divisionToCreate);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('GET_ALL_DIVISIONS')")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

}
