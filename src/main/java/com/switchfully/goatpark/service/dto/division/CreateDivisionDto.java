package com.switchfully.goatpark.service.dto.division;

import com.switchfully.goatpark.repository.division.DivisionRepository;

public class CreateDivisionDto {

    private String name;

    private String originalName;

    private String director;

    private Integer parentId;

    public CreateDivisionDto(String name, String originalName, String director, Integer parentId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentId = parentId;
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

    public Integer getParentId() {
        return parentId;
    }
}
