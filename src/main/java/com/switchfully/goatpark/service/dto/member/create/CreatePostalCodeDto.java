package com.switchfully.goatpark.service.dto.member.create;

import javax.persistence.Column;

public class CreatePostalCodeDto {

    private String code;
    private String label;

    public CreatePostalCodeDto(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
