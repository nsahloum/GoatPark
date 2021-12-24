package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.address.PostalCode;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.*;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Person map(CreateMemberDto createMemberDto) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder()
                .withName(createMemberDto.name())
                .withMembership(
                new Membership(
                        new LicensePlate(
                                createMemberDto.licensePlate().getNumberPlate(),
                                createMemberDto.licensePlate().getCountryCode())))
                .withEmailAddress(
                        new EmailAddress(
                                createMemberDto.email().getUsername(),
                                createMemberDto.email().getDomain()));
        if (createMemberDto.address() != null) {
                            personBuilder.withAddress(
                    new Address(
                            createMemberDto.address().getStreetName(),
                            createMemberDto.address().getStreetNumber(),
                            new PostalCode(
                                    createMemberDto.address().getPostalCode().getCode(),
                                    createMemberDto.address().getPostalCode().getLabel())));

        }
        if (createMemberDto.phoneNumber() != null) {
            personBuilder.withPhoneNumber(
                    new PhoneNumber(
                            createMemberDto.phoneNumber().getPrefix(),
                            createMemberDto.phoneNumber().getNumber()));
        }
        if (createMemberDto.mobileNumber() != null) {
            personBuilder.withMobileNumber(
                    new PhoneNumber(
                            createMemberDto.mobileNumber().getPrefix(),
                            createMemberDto.mobileNumber().getNumber()));
        }
        return personBuilder.build();
    }

    public PersonDto map(Person person, String keycloackId) {
        PersonDto.PersonDtoBuilder personDtoBuilder = new PersonDto.PersonDtoBuilder()
                .withId(person.getId())
                .withName(person.getName())
                .withKeycloakId(keycloackId)
                .withEmailAddressDto(
                        new EmailAddressDto(
                                person.getEmailAddress().getUsername(),
                                person.getEmailAddress().getDomain()))
                .withAddressDto(
                        new AddressDto(
                                person.getAddress().getStreetName(),
                                person.getAddress().getStreetNumber(),
                                new PostalCodeDto(
                                        person.getAddress().getPostalCode().getId(),
                                        person.getAddress().getPostalCode().getCode(),
                                        person.getAddress().getPostalCode().getLabel())));
        if (person.getPhoneNumber() != null) {
            personDtoBuilder.withPhoneNumberDto(
                    new PhoneNumberDto(
                            person.getPhoneNumber().getPrefix(),
                            person.getPhoneNumber().getNumber()));
        }
        if (person.getMobileNumber() != null) {
            personDtoBuilder.withMobileNumber(
                    new PhoneNumberDto(
                            person.getMobileNumber().getPrefix(),
                            person.getMobileNumber().getNumber()));
        }
        return personDtoBuilder.build();
    }

    public MembersDto map(Person person) {
        MembersDto.MemberDtoBuilder memberDtoBuilder = new MembersDto.MemberDtoBuilder()
                .withId(person.getId())
                .withName(person.getName())
                .withEmailAddressDto(
                        new EmailAddressDto(
                                person.getEmailAddress().getUsername(),
                                person.getEmailAddress().getDomain()))
                .withMembershipDto(
                        new MembershipDto(
                                person.getMembership().getRegistrationDate(),
                                person.getMembership().getLicensePlate().getNumberPlate())
                );
        if (person.getPhoneNumber() != null) {
            memberDtoBuilder.withPhoneNumberDto(
                    new PhoneNumberDto(
                            person.getPhoneNumber().getPrefix(),
                            person.getPhoneNumber().getNumber()));
        }
        if (person.getMobileNumber() != null) {
            memberDtoBuilder.withMobileNumberDto(
                    new PhoneNumberDto(
                            person.getMobileNumber().getPrefix(),
                            person.getMobileNumber().getNumber()));
        }
        return memberDtoBuilder.build();
    }
}
