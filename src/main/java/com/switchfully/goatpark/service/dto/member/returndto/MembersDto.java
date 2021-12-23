package com.switchfully.goatpark.service.dto.member.returndto;

public class MembersDto {
    private final int id;
    private final String name;
    private final PhoneNumberDto phoneNumberDto;
    private final String email;
    private final MembershipDto membershipDto;

    public MembersDto(MemberDtoBuilder memberDtoBuilder){
        this.id = memberDtoBuilder.id;
        this.name = memberDtoBuilder.name;
        this.phoneNumberDto = memberDtoBuilder.phoneNumberDto;
        this.email = memberDtoBuilder.emailAddressDto.getUsername() + "@" + memberDtoBuilder.emailAddressDto.getDomain();
        this.membershipDto = memberDtoBuilder.membershipDto;
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

    public String getEmailAdresDto() {
        return email;
    }

    public MembershipDto getMembershipDto() {
        return membershipDto;
    }

    public static class MemberDtoBuilder {
        private int id;
        private String name;
        private PhoneNumberDto phoneNumberDto;
        private EmailAddressDto emailAddressDto;
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
            this.phoneNumberDto = phoneNumberDto;
            return this;
        }

        public MemberDtoBuilder withEmailAddressDto(EmailAddressDto emailAddressDto) {
            this.emailAddressDto = emailAddressDto;
            return this;
        }

        public MemberDtoBuilder withMembershipDto(MembershipDto membershipDto) {
            this.membershipDto = membershipDto;
            return this;
        }

        public MembersDto build() {
            return new MembersDto(this);
        }
    }
}
