package com.switchfully.goatpark.domain.phonenumber;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void given_PrefixTooLong_ThenError() {
        Throwable exception = catchThrowable(() -> new PhoneNumber("00032", "500600")) ;
        Assertions.assertThat(exception).isInstanceOf(IllegalArgumentException.class).hasMessage("Prefix is 4 digits maximum");
    }

}