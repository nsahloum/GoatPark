package com.switchfully.goatpark.domain.division;

import javax.persistence.*;

@Entity
@Table(name = "DIVISIONS")

public class Division {

    @Id
    //@SequenceGenerator(name = "divisions_id_seq", sequenceName = "DIVISIONS_ID_SEQ", initialValue = 1, allocationSize = 1)
   // @GeneratedValue//(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "director")
    private String director;

    public Division(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    private Division() {
    }

    public int getId() {
        return id;
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
