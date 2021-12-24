package com.switchfully.goatpark.domain.division;

import javax.persistence.*;

@Entity
@Table(name = "DIVISIONS")

public class Division {

    @Id
    @GeneratedValue(generator = "division_seq")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "director")
    private String director;

    @Column(name = "parent_division_id")
    private Integer parentId;

    public Division(String name, String originalName, String director, Integer parentId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentId = parentId;
    }

    protected Division() {
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

    public Integer getParentId() {
        return parentId;
    }
}
