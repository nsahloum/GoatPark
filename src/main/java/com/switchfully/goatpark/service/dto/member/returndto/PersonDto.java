package com.switchfully.goatpark.service.dto.member.returndto;

public class PersonDto {

    private final int id;
    private final String name;
    private final PhoneNumberDto phoneNumberDto;
    private final EmailAdresDto emailAdresDto;
    private final MembershipDto membershipDto;
    private final PhoneNumberDto mobileNumber;
    private final AddressDto addressDto;
    private final String keycloakId;

    private PersonDto(PersonDtoBuilder personDtoBuilder) {
        this.id = personDtoBuilder.id;
        this.name = personDtoBuilder.name;
        this.keycloakId = personDtoBuilder.keycloakId;
        this.phoneNumberDto = personDtoBuilder.phoneNumberDto;
        this.mobileNumber = personDtoBuilder.mobileNumber;
        this.emailAdresDto = personDtoBuilder.emailAdresDto;
        this.addressDto = personDtoBuilder.addressDto;
        this.membershipDto = personDtoBuilder.membershipDto;
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

    public EmailAdresDto getEmailAdresDto() {
        return emailAdresDto;
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
        private EmailAdresDto emailAdresDto;
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

        public PersonDtoBuilder withEmailAddressDto(EmailAdresDto emailAdresDto) {
            this.emailAdresDto = emailAdresDto;
            return this;
        }

        public PersonDtoBuilder withAddressDto(AddressDto addressDto) {
            this.addressDto = addressDto;
            return this;
        }

        public PersonDtoBuilder withMembershipDto(MembershipDto membershipDto) {
            this.membershipDto = membershipDto;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(this);
        }

        public PersonDtoBuilder withKeycloakId(String keycloakId) {
            this.keycloakId = keycloakId;
            return this;
        }
    }
}
