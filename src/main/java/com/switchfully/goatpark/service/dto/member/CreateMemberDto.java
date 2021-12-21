package com.switchfully.goatpark.service.dto.member;

public class CreateMemberDto {

    private String username;
    private String password;

    private String name;
    private CreateAddressDto createAddressDto;
    private CreatePhoneNumberDto phoneNumber;
    private CreatePhoneNumberDto mobileNumber;
    private CreateEmailDto emailAddress;
    private CreateLicensePlateDto licensePlate;

    public CreateMemberDto(String username, String password, String name, CreateAddressDto createAddressDto, CreatePhoneNumberDto phoneNumber, CreatePhoneNumberDto mobileNumber, CreateEmailDto emailAddress, CreateLicensePlateDto licensePlate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.createAddressDto = createAddressDto;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.licensePlate = licensePlate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }

    public CreatePhoneNumberDto getPhoneNumber() {
        return phoneNumber;
    }

    public CreatePhoneNumberDto getMobileNumber() {
        return mobileNumber;
    }

    public CreateEmailDto getEmailAddress() {
        return emailAddress;
    }

    public CreateLicensePlateDto getLicensePlate() {
        return licensePlate;
    }
}
