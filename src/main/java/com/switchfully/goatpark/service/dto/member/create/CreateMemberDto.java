package com.switchfully.goatpark.service.dto.member.create;

import javax.validation.constraints.NotEmpty;

public record CreateMemberDto(
        String username,
        String password,
        String name,
        CreateAddressDto createAddressDto,
        @NotEmpty(message = "please provide an phonenumber") CreatePhoneNumberDto phoneNumber,
        CreatePhoneNumberDto mobileNumber,
        CreateEmailDto emailAddress,
        CreateLicensePlateDto licensePlate) {
}
