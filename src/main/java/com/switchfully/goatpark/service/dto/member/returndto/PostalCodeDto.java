package com.switchfully.goatpark.service.dto.member.returndto;

public class PostalCodeDto {

    private final int id;
    private final String code;
    private final String label;

    public PostalCodeDto(int id, String code, String label) {
        this.id = id;
        this.code = code;
        this.label = label;
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

}
