package com.switchfully.goatpark.service;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.exception.NotUniqueException;
import com.switchfully.goatpark.exception.NullException;
import com.switchfully.goatpark.exception.PhoneNumberIsRequiredException;
import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import org.springframework.stereotype.Component;

@Component
public class AssertFieldService {

    private static DivisionRepository divisionRepository;

    public AssertFieldService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public static void assertPersonIsValid(Person person) {
        assertPhoneNumberIsValid(person);
        assertAddressIsValid(person.getAddress());

    }

    public static void assertParkingLotIsValid(CreateParkingLotDto parkingLotToCreate) {
        assertAddressIsValid(parkingLotToCreate.getAddress());
    }

    public static void assertDivisionIsValid(CreateDivisionDto createDivisionDto) {
        assertFieldIsNotNull(createDivisionDto.getName(), "The name is required");
        assertFieldIsNotNull(createDivisionDto.getOriginalName(), "The original name is required");
        assertFieldIsNotNull(createDivisionDto.getDirector(), "The director is required");
        isValidDivision(createDivisionDto);
    }

    private static void isValidDivision(CreateDivisionDto createDivisionDto) {
        if (divisionRepository.findDivisionByName(createDivisionDto.getName()) == null) {
            if (divisionRepository.findDivisionByOriginalName(createDivisionDto.getOriginalName()) == null) {
                return;
            }
        }
            throw new NotUniqueException("This company already exist in the database");
    }

    private static void assertPhoneNumberIsValid(Person person) {
        if (person.getPhoneNumber() == null && person.getMobileNumber() == null) {
            throw new PhoneNumberIsRequiredException("At least one telephone number is required");
        }
    }

    private static void assertAddressIsValid(Address address) {
        assertFieldIsNotNull(address, "A valid address is required");
        assertFieldIsNotNull(address.getStreetName(), "A valid streetname is required");
        assertFieldIsNotNull(address.getStreetNumber(), "A valid streetnumber is required");
        assertFieldIsNotNull(address.getPostalCode().getCode(), "A valid postalcode is required");
        assertFieldIsNotNull(address.getPostalCode().getLabel(), "A valid city is required");
    }

    private static <T> void assertFieldIsNotNull(T t, String message) {
        if (t == null) {
            throw new NullException(message);
        }
    }
}
