package com.switchfully.goatpark.service.dto.division;

public class CreateDivisionDto {

    private final String name;

    private final String originalName;

    private final String director;

    private final Integer parentId;

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
