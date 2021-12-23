package com.switchfully.goatpark.service.dto.division;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateDivisionDto {

    private String name;

    private String originalName;

    private String director;

    public CreateDivisionDto(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }



}
