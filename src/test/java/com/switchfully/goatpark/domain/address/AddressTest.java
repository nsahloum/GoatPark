package com.switchfully.goatpark.domain.address;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.address.PostalCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void given_AValidAddress_ReturnIllegalArgument() {
        Address address = new Address("Avenue Alexandre", "2", new PostalCode("1330", "Rixensart"));

        Assertions.assertEquals("Avenue Alexandre", address.getStreetName());
        Assertions.assertEquals("2", address.getStreetNumber());
        Assertions.assertEquals("1330, Rixensart", address.getPostalCode().toString());
    }
}