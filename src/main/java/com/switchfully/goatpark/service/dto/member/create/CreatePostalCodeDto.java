package com.switchfully.goatpark.service.dto.member.create;

public class CreatePostalCodeDto {

    private final String code;
    private final String label;

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
