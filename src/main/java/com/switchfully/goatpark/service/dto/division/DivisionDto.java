package com.switchfully.goatpark.service.dto.division;

import com.fasterxml.jackson.annotation.JsonInclude;


public class DivisionDto {

    private int id;

    private String name;

    private String originalName;

    private String director;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer parentId;


    public int getId() {
        return id;
    }

    public DivisionDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DivisionDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public DivisionDto setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public DivisionDto setDirector(String director) {
        this.director = director;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public DivisionDto setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }
}
