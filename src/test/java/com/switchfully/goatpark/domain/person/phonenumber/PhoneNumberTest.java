package com.switchfully.goatpark.domain.person.phonenumber;

import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class PhoneNumberTest {

    @Test
    void given_PrefixTooLong_ThenError() {
        Throwable exception = catchThrowable(() -> new PhoneNumber("00032", "500600")) ;
        Assertions.assertThat(exception).isInstanceOf(IllegalArgumentException.class).hasMessage("Prefix is 4 digits maximum");
    }

}