package com.switchfully.goatpark.service.dto.division;

import javax.persistence.Column;

public class CreateDivisionDto {

    private String name;

    private String originalName;

    private String director;



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
