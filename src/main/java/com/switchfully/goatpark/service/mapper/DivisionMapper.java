package com.switchfully.goatpark.service.mapper;
import com.switchfully.goatpark.domain.division.Division;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division mapCreateDivisionDtoToDivision (CreateDivisionDto createDivisionDto) {
        return new Division(createDivisionDto.getName(), createDivisionDto.getOriginalName(), createDivisionDto.getDirector());
    }

}
