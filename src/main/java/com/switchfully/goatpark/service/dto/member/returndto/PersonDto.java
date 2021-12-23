package com.switchfully.goatpark.service.dto.member.returndto;

public class PersonDto {

    private final int id;
    private final String name;
    private final PhoneNumberDto phoneNumberDto;
    private final EmailAddressDto emailAddressDto;
    private final PhoneNumberDto mobileNumber;
    private final AddressDto addressDto;
    private final String keycloakId;

    private PersonDto(int id, String name, PhoneNumberDto phoneNumberDto, EmailAddressDto emailAddressDto, PhoneNumberDto mobileNumber, AddressDto addressDto, String keycloakId) {
        this.id = id;
        this.name = name;
        this.phoneNumberDto = phoneNumberDto;
        this.emailAddressDto = emailAddressDto;

        this.mobileNumber = mobileNumber;
        this.addressDto = addressDto;
        this.keycloakId = keycloakId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumberDto getPhoneNumberDto() {
        return phoneNumberDto;
    }

    public PhoneNumberDto getMobileNumber() {
        return mobileNumber;
    }

    public EmailAddressDto getEmailAddressDto() {
        return emailAddressDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public static class PersonDtoBuilder {
        private int id;
        private String name;
        private PhoneNumberDto phoneNumberDto;
        private PhoneNumberDto mobileNumber;
        private EmailAddressDto emailAddressDto;
        private AddressDto addressDto;
        private MembershipDto membershipDto;
        private String keycloakId;

        public PersonDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public PersonDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonDtoBuilder withPhoneNumberDto(PhoneNumberDto phoneNumberDto) {
            this.phoneNumberDto = phoneNumberDto;
            return this;
        }

        public PersonDtoBuilder withMobileNumber(PhoneNumberDto mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PersonDtoBuilder withEmailAddressDto(EmailAddressDto emailAddressDto) {
            this.emailAddressDto = emailAddressDto;
            return this;
        }

        public PersonDtoBuilder withAddressDto(AddressDto addressDto) {
            this.addressDto = addressDto;
            return this;
        }

        public PersonDtoBuilder withKeycloakId(String keycloakId) {
            this.keycloakId = keycloakId;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(id,name,phoneNumberDto, emailAddressDto, mobileNumber,addressDto,keycloakId);
        }
    }
}
