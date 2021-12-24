package com.switchfully.goatpark.service.dto.member.returndto;

public class PersonDto {

    private final int id;
    private final String name;
    private final PhoneNumberDto phoneNumber;
    private final PhoneNumberDto mobileNumber;
    private final EmailAddressDto email;
    private final AddressDto address;
    private final String keycloakId;

    private PersonDto(int id, String name, PhoneNumberDto phoneNumberDto, PhoneNumberDto mobileNumber, EmailAddressDto emailAddressDto, AddressDto address, String keycloakId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumberDto;
        this.mobileNumber = mobileNumber;
        this.email = emailAddressDto;
        this.address = address;
        this.keycloakId = keycloakId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumberDto getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberDto getMobileNumber() {
        return mobileNumber;
    }

    public EmailAddressDto getEmail() {
        return email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public static class PersonDtoBuilder {
        private int id;
        private String name;
        private PhoneNumberDto phoneNumber;
        private PhoneNumberDto mobileNumber;
        private EmailAddressDto email;
        private AddressDto address;
        private MembershipDto membership;
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
            this.phoneNumber = phoneNumberDto;
            return this;
        }

        public PersonDtoBuilder withMobileNumber(PhoneNumberDto mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public PersonDtoBuilder withEmailAddressDto(EmailAddressDto emailAddressDto) {
            this.email = emailAddressDto;
            return this;
        }

        public PersonDtoBuilder withAddressDto(AddressDto addressDto) {
            this.address = addressDto;
            return this;
        }

        public PersonDtoBuilder withKeycloakId(String keycloakId) {
            this.keycloakId = keycloakId;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(id,name, phoneNumber, mobileNumber, email, address,keycloakId);
        }
    }
}
