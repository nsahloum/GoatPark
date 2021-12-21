package com.switchfully.goatpark.domain.emailaddress;

import org.junit.jupiter.api.Test;

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
}