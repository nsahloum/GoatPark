package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.address.PostalCode;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.service.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.service.domain.person.membership.Membership;
import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.*;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Person map(CreateMemberDto createMemberDto) {
        return new Person(
                createMemberDto.name(),
                new PhoneNumber(
                        createMemberDto.phoneNumber().getPrefix(),
                        createMemberDto.phoneNumber().getNumber()),
                new PhoneNumber(
                        createMemberDto.mobileNumber().getPrefix(),
                        createMemberDto.mobileNumber().getNumber()),
                new EmailAddress(
                        createMemberDto.emailAddress().getUsername(),
                        createMemberDto.emailAddress().getDomain()),
                new Address(
                        createMemberDto.createAddressDto().getStreetName(),
                        createMemberDto.createAddressDto().getStreetNumber(),
                        new PostalCode(
                                createMemberDto.createAddressDto().getPostalCode().getCode(),
                                createMemberDto.createAddressDto().getPostalCode().getLabel())),
                new Membership(
                        new LicensePlate(
                                createMemberDto.licensePlate().getNumberPlate(),
                                createMemberDto.licensePlate().getCountryCode())));
    }

    public PersonDto map(Person person, String keycloackId) {
        return new PersonDto.PersonDtoBuilder()
                .withId(person.getId())
                .withName(person.getName())
                .withKeycloakId(keycloackId)
                .withPhoneNumberDto(
                        new PhoneNumberDto(
                                person.getPhoneNumber().getPrefix(),
                                person.getPhoneNumber().getNumber()))
                .withMobileNumber(
                        new PhoneNumberDto(
                                person.getMobileNumber().getPrefix(),
                                person.getMobileNumber().getNumber()))
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
                                        person.getAddress().getPostalCode().getLabel())))
                .build();
    }

    public MembersDto map(Person person) {
        return new MembersDto.MemberDtoBuilder()
                .withId(person.getId())
                .withName(person.getName())
                .withPhoneNumberDto(
                        new PhoneNumberDto(
                                person.getPhoneNumber().getPrefix(),
                                person.getPhoneNumber().getNumber()))
                .withEmailAddressDto(
                        new EmailAddressDto(
                                person.getEmailAddress().getUsername(),
                                person.getEmailAddress().getDomain()))
                .withMembershipDto(
                        new MembershipDto(
                                person.getMembership().getRegistrationDate(),
                                person.getMembership().getLicensePlate().getNumberPlate())
                )
                .build();
    }
}
