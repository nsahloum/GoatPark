package com.switchfully.goatpark.service.dto.division;

public class DivisionDto {

    private int id;
    
    private String name;

    private String originalName;

    private String director;

    public DivisionDto (String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }
}
