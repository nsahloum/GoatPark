package com.switchfully.goatpark.service;

import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.exception.NullException;
import com.switchfully.goatpark.exception.PhoneNumberIsRequiredException;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;

public class AssertFieldService {

    public static void assertPersonIsValid(Person person) {
        assertPhoneNumberIsValid(person);
        assertFieldIsNotNull(person.getAddress(), "A valid address is required");
    }

    private static void assertPhoneNumberIsValid(Person person) {
        if (person.getPhoneNumber() == null && person.getMobileNumber() == null) {
            throw new PhoneNumberIsRequiredException("At least one telephone number is required");
        }
    }

    private static <T> void assertFieldIsNotNull(T t, String message) {
        if (t == null){
            throw new NullException(message);
        }
    }


}
