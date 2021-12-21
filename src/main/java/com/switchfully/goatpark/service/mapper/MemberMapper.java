package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.address.PostalCode;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.member.CreateMemberDto;
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
}
