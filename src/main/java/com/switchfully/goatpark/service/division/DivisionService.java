package com.switchfully.goatpark.service.division;

import com.switchfully.goatpark.domain.division.Division;
import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import com.switchfully.goatpark.service.mapper.DivisionMapper;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    private DivisionMapper divisionMapper;
    private DivisionRepository divisionRepository;

    public DivisionService(DivisionMapper divisionMapper, DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
    }


    public DivisionDto createDivision(CreateDivisionDto divisionToCreate) {
        Division divisionToSave = divisionMapper.mapCreateDivisionDtoToDivision(divisionToCreate);
        Division divisionSaved = divisionRepository.save(divisionToSave);
        return divisionMapper.mapDivisionToDivisionDto(divisionSaved);
    }
}
