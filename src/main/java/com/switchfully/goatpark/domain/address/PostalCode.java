package com.switchfully.goatpark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "POSTAL_CODE")
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    public PostalCode(String code, String label) {
        this.code = code;
        this.label = label;
    }

    protected PostalCode() {
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return code + ", " + label;
    }
}
