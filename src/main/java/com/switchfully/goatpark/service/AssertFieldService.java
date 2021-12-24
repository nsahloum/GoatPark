package com.switchfully.goatpark.service;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.division.Division;
import com.switchfully.goatpark.domain.parkinglot.Category;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.exception.*;
import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.parkingallocation.CreateParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class AssertFieldService {

    private static DivisionRepository divisionRepository;

    public AssertFieldService(DivisionRepository divisionRepository) {
        AssertFieldService.divisionRepository = divisionRepository;
    }

    public static void assertParkingAllocationIsValid(CreateParkingAllocationDto createParkingAllocation) {
        assertIntegerValueAboveZero(createParkingAllocation.getPersonId(), "Invalid person ID");
        assertIntegerValueAboveZero(createParkingAllocation.getParkingLotId(), "Invalid parking lot ID");
    }

    private static void assertPersonIsValid(Person person) {
        assertPhoneNumberIsValid(person);
        assertAddressIsValid(person.getAddress());
        assertEmailIsValid(person.getEmailAddress());
    }

    public static void assertMembershipIsValid(Person person) {
        assertPersonIsValid(person);
        assertFieldIsNotNull(person.getMembership().getLicensePlate(), "Licenseplate is required");
    }

    private static void assertEmailIsValid(EmailAddress emailAddress) {
        assertFieldIsNotNull(emailAddress.getUsername(), "The username is required");
        assertFieldIsNotNull(emailAddress.getDomain(), "The domain is required");
    }

    public static void assertParkingLotIsValid(CreateParkingLotDto parkingLotToCreate) {
        assertFieldIsNotNull(parkingLotToCreate.getName(), "The parkinglot should have a name");
        assertFieldIsNotNull(parkingLotToCreate.getCategory(), "Please define the category");
        assertAddressIsValid(parkingLotToCreate.getAddress());
        assertPersonIsValid(parkingLotToCreate.getContactPerson());
        assertIntegerValueAboveZero(parkingLotToCreate.getMaximumCapacity(), "Capacity is required");
        assertIntegerValueAboveZero(parkingLotToCreate.getPricePerHour(), "Price per hour is required");
    }

    private static void assertIntegerValueAboveZero(double maximumCapacity, String message) {
        if (maximumCapacity <= 0) {
            throw new WayTooSmallCapacityException(message);
        }
        assertFieldIsNotNull(maximumCapacity, message);
    }

    public static void assertDivisionIsValid(CreateDivisionDto createDivisionDto) {
        isValidDivision(createDivisionDto);
        assertFieldIsNotNull(createDivisionDto.getName(), "The name is required");
        assertEnumIsCorrect(createDivisionDto.getOriginalName(), "The original name is required");
        assertFieldIsNotNull(createDivisionDto.getDirector(), "The director is required");
    }

    private static void assertEnumIsCorrect(String category, String message) {
        if (EnumUtils.isValidEnum(Category.class, category)) {
            throw new IncorrectEnumValueException(message);
        }
    }

    private static void isValidDivision(CreateDivisionDto createDivisionDto) {
        Division divisionName = divisionRepository.findDivisionByName(createDivisionDto.getName());
        Division divisionOriginalName = divisionRepository.findDivisionByOriginalName(createDivisionDto.getOriginalName());
        if ((divisionName != null) || (divisionOriginalName != null)) {
            throw new NotUniqueException("This company already exist in the database");
        }
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
