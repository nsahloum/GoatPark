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
                createMemberDto.getName(),
                new PhoneNumber(
                        createMemberDto.getPhoneNumber().getPrefix(),
                        createMemberDto.getPhoneNumber().getNumber()
                ),
                new PhoneNumber(
                        createMemberDto.getMobileNumber().getPrefix(),
                        createMemberDto.getMobileNumber().getNumber()
                ),
                new EmailAddress(
                        createMemberDto.getEmailAddress().getUsername(),
                        createMemberDto.getEmailAddress().getDomain()
                ),
                new Address(
                        createMemberDto.getCreateAddressDto().getStreetName(),
                        createMemberDto.getCreateAddressDto().getStreetNumber(),
                        new PostalCode(
                                createMemberDto.getCreateAddressDto().getPostalCode().getCode(),
                                createMemberDto.getCreateAddressDto().getPostalCode().getLabel()
                        )),
                new Membership(
                        new LicensePlate(
                                createMemberDto.getLicensePlate().getNumberPlate(),
                                createMemberDto.getLicensePlate().getCountryCode()
                        )
                )
        );
    }

    public PersonDto map(Person person) {
        return new PersonDto.PersonDtoBuilder()
                .withId(person.getId())
                .withName(person.getName())
                .withPhoneNumberDto(
                        new PhoneNumberDto(
                                person.getId(),
                                person.getPhoneNumber().getPrefix(),
                                person.getPhoneNumber().getNumber()))
                .withMobileNumber(
                        new PhoneNumberDto(
                                person.getId(),
                                person.getMobileNumber().getPrefix(),
                                person.getMobileNumber().getNumber()))
                .withEmailAddressDto(
                        new EmailAdresDto(
                                person.getEmailAddress().getId(),
                                person.getEmailAddress().getUsername(),
                                person.getEmailAddress().getDomain()))
                .withAddressDto(
                        new AddressDto(
                                person.getAddress().getId(),
                                person.getAddress().getStreetName(),
                                person.getAddress().getStreetNumber(),
                                new PostalCodeDto(
                                        person.getAddress().getPostalCode().getId(),
                                        person.getAddress().getPostalCode().getCode(),
                                        person.getAddress().getPostalCode().getLabel())))
                .build();
    }
}
