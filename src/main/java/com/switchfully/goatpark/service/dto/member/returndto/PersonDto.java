package com.switchfully.goatpark.service.dto.member.returndto;

public class PersonDto {

    private final int id;
    private final String name;
    private final PhoneNumberDto phoneNumberDto;
    private final PhoneNumberDto mobileNumber;
    private final EmailAdresDto emailAdresDto;
    private final AddressDto addressDto;
//    private final MembershipDto membershipDto;

    private PersonDto(int id, String name, PhoneNumberDto phoneNumberDto, PhoneNumberDto mobileNumber, EmailAdresDto emailAdresDto, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.phoneNumberDto = phoneNumberDto;
        this.mobileNumber = mobileNumber;
        this.emailAdresDto = emailAdresDto;
        this.addressDto = addressDto;
//        this.membershipDto = membershipDto;
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

    public static class PersonDtoBuilder {
        private int id;
        private String name;
        private PhoneNumberDto phoneNumberDto;
        private PhoneNumberDto mobileNumber;
        private EmailAdresDto emailAdresDto;
        private AddressDto addressDto;
        private MembershipDto membershipDto;

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

//        public PersonDtoBuilder withMembershipDto(MembershipDto membershipDto) {
//            this.membershipDto = membershipDto;
//            return this;
//        }

        public PersonDto build() {
            return new PersonDto(id, name, phoneNumberDto, mobileNumber,emailAdresDto, addressDto);
        }
    }
}
