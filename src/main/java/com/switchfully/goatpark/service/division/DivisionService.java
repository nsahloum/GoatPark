package com.switchfully.goatpark.service.division;

import com.switchfully.goatpark.domain.division.Division;
import com.switchfully.goatpark.exception.NotUniqueException;
import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import com.switchfully.goatpark.service.mapper.DivisionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {
    private DivisionMapper divisionMapper;
    private DivisionRepository divisionRepository;

    public DivisionService(DivisionMapper divisionMapper, DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
    }


    public DivisionDto createDivision(CreateDivisionDto divisionToCreate) {
        if (!isValidDivision(divisionToCreate)) {
            throw new NotUniqueException("This company already exist in the database");
        }

        Division divisionToSave = divisionMapper.mapCreateDivisionDtoToDivision(divisionToCreate);
        divisionRepository.save(divisionToSave);
        return divisionMapper.mapDivisionToDivisionDto(divisionToSave);


    }

    public boolean isValidDivision(CreateDivisionDto createDivisionDto) {
        if (divisionRepository.findDivisionByName(createDivisionDto.getName()) == null) {
            if (divisionRepository.findDivisionByOriginalName(createDivisionDto.getOriginalName()) == null) {
                return true;
            }
        }
        return false;

    }

    public List<DivisionDto> getAllDivisions() {
        return divisionRepository.getAllDivisions().stream().map(division -> divisionMapper.mapDivisionToDivisionDto(division)).collect(Collectors.toList());
    }
}

