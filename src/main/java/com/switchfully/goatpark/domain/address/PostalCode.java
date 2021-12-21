package com.switchfully.goatpark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "POSTALCODE")
public class PostalCode {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    public PostalCode(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public PostalCode() {
    }
}
