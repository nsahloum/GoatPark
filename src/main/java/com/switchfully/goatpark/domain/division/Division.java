package com.switchfully.goatpark.domain.division;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table (name = "DIVISIONS")
public class Division {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "director")
    private String director;

    public Division (String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    private Division() {
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
