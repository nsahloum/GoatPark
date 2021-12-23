package com.switchfully.goatpark.service.mapper;
import com.switchfully.goatpark.service.domain.division.Division;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    public Division mapCreateDivisionDtoToDivision (CreateDivisionDto createDivisionDto) {
        return new Division(
                createDivisionDto.getName(),
                createDivisionDto.getOriginalName(),
                createDivisionDto.getDirector(),
                createDivisionDto.getParentId()
        );
    }

    public DivisionDto mapDivisionToDivisionDto (Division division){
        return new DivisionDto()
                .setDirector(division.getDirector())
                .setId(division.getId())
                .setName(division.getName())
                .setOriginalName(division.getOriginalName())
                .setParentId((division.getParentId()));
    }


}
