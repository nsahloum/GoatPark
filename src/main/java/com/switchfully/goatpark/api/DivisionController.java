package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.division.DivisionService;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/divisions", produces = MediaType.APPLICATION_JSON_VALUE)
public class DivisionController {
    private DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('CREATE_DIVISION')")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDto createDivision(@RequestBody CreateDivisionDto divisionToCreate){
        return divisionService.createDivision(divisionToCreate);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('GET_ALL_DIVISIONS')")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

}
