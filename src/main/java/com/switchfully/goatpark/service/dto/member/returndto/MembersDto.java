package com.switchfully.goatpark.service.dto.member.returndto;

public class MembersDto {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final String mobileNumber;
    private final String email;
    private final MembershipDto membership;

    public MembersDto(int id, String name, String phoneNumber, String mobileNumber, String email, MembershipDto membershipDto) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.membership = membershipDto;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public MembershipDto getMembership() {
        return membership;
    }

    public static class MemberDtoBuilder {
        private int id;
        private String name;
        private String phoneNumberDto;
        private String mobileNumberDto;
        private String emailAddressDto;
        private MembershipDto membershipDto;

        public MemberDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public MemberDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public MemberDtoBuilder withPhoneNumberDto(PhoneNumberDto phoneNumberDto) {
            this.phoneNumberDto = phoneNumberDto.getPrefix() + " / " + phoneNumberDto.getNumber();
            return this;
        }

        public MemberDtoBuilder withMobileNumberDto(PhoneNumberDto mobileNumberDto) {
            this.mobileNumberDto = mobileNumberDto.getPrefix() + " / " + mobileNumberDto.getNumber();
            return this;
        }

        public MemberDtoBuilder withEmailAddressDto(EmailAddressDto emailAddressDto) {
            this.emailAddressDto = emailAddressDto.getUsername() + "@" + emailAddressDto.getDomain();
            return this;
        }

        public MemberDtoBuilder withMembershipDto(MembershipDto membershipDto) {
            this.membershipDto = membershipDto;
            return this;
        }

        public MembersDto build() {
            return new MembersDto(id, name, phoneNumberDto, mobileNumberDto, emailAddressDto, membershipDto);
        }
    }
}
