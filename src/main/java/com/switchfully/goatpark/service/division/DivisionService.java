package com.switchfully.goatpark.service.division;

import com.switchfully.goatpark.domain.division.Division;
import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.AssertFieldService;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import com.switchfully.goatpark.service.mapper.DivisionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {

    private final DivisionMapper divisionMapper;
    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionMapper divisionMapper, DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
    }


    public DivisionDto createDivision(CreateDivisionDto divisionToCreate) {
        AssertFieldService.assertDivisionIsValid(divisionToCreate);

        Division divisionToSave = divisionMapper.mapCreateDivisionDtoToDivision(divisionToCreate);
        divisionRepository.save(divisionToSave);
        return divisionMapper.mapDivisionToDivisionDto(divisionToSave);
    }

    public List<DivisionDto> getAllDivisions() {
        return divisionRepository.getAllDivisions().stream().map(divisionMapper::mapDivisionToDivisionDto).collect(Collectors.toList());
    }
}

