package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.service.dto.member.CreateMemberDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MemberMapper {

    public Person map(CreateMemberDto createMemberDto) {
        return new Person(
                createMemberDto.getName(),
                createMemberDto.getPhoneNumber(),
                createMemberDto.getMobileNumber(),
                createMemberDto.getEmailAddress(),
                createMemberDto.getAddress(),
                new Membership(
//                        // TODO: might have to adept this
//                        LocalDate.now(),
                        createMemberDto.getLicensePlate())
                );
    }
}
