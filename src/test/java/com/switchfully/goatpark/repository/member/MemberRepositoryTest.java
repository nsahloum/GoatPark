package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.address.PostalCode;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(
                "name",
                new PhoneNumber("0475", "757575"),
                new PhoneNumber("0475", "757575"),
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