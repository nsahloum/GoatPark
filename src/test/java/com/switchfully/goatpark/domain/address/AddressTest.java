package com.switchfully.goatpark.domain.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void given_UncompleteAddress_ReturnIllegalArgument() {
        Address address = new Address("Avenue Alexandre", "2", new PostalCode("1330", "Rixensart"));

        Assertions.assertEquals("Avenue Alexandre", address.getStreetName());
        Assertions.assertEquals("2", address.getStreetNumber());
        Assertions.assertEquals("1330, Rixensart", address.getPostalCode().toString());
    }

}