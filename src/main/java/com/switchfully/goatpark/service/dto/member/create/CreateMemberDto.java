package com.switchfully.goatpark.service.dto.member.create;

public record CreateMemberDto(
        String username,
        String password,
        String name,
        CreateAddressDto address,
        CreatePhoneNumberDto phoneNumber,
        CreatePhoneNumberDto mobileNumber,
        CreateEmailDto email,
        CreateLicensePlateDto licensePlate) {
}
