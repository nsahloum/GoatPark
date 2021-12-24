package com.switchfully.goatpark.domain.person.emailaddress;

import com.switchfully.goatpark.exception.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class EmailAddressTest {

    @Test
    void testToString() {
        EmailAddress emailAddress = new EmailAddress("julian", "gmail.com");
        assertEquals("julian@gmail.com", emailAddress.toString());
    }

    @Test
    void isEmailAddressValid() {
        EmailAddress emailAddress = new EmailAddress("julian", "gmail.com");
        assertTrue(EmailAddress.isValidEmail(emailAddress.toString()));
    }
    @Test
    void given_WrongEmailAddress_Then_ErrorIsThrown() {
        Throwable exception = catchThrowable(() -> new EmailAddress("juna", "goatpark"));

        assertThat(exception).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This email address is not valid!");
        assertThat(exception).isNotInstanceOf(IncorrectEnumValueException.class);
        assertThat(exception).isNotInstanceOf(NotUniqueException.class);
        assertThat(exception).isNotInstanceOf(ParkingLotNotFoundException.class);
        assertThat(exception).isNotInstanceOf(PersonDoesNotExistException.class);
        assertThat(exception).isNotInstanceOf(PhoneNumberIsRequiredException.class);
        assertThat(exception).isNotInstanceOf(UserAlreadyExistsException.class);
        assertThat(exception).isNotInstanceOf(WayTooSmallCapacityException.class);
    }
}