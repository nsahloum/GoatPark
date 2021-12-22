package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.address.PostalCode;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.service.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.service.domain.person.membership.Membership;
import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    private Person person;

    @BeforeAll
    void setUp() {
        person = new Person(
                "name",
                new PhoneNumber("0475", "757575"),
                null,
                new EmailAddress(
                        "goat",
                        "goaties.com"),
                new Address(
                        "streetName",
                        "10",
                        new PostalCode(
                                "1234",
                                "goat ranch")),
                new Membership(
                        new LicensePlate(
                                "goat - 123",
                                "BE")));
    }

    @Test
    void registerMember() {
        Person person1 = memberRepository.registerMember(person);

        assertThat(person1.getName()).isEqualTo("name");
    }
}