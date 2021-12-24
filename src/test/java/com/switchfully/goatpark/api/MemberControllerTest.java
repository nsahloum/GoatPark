package com.switchfully.goatpark.api;

import com.switchfully.goatpark.exception.PhoneNumberIsRequiredException;
import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.service.KeycloakService;
import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.address.PostalCode;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.membership.LicensePlate;
import com.switchfully.goatpark.domain.person.membership.Membership;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.member.create.*;
import com.switchfully.goatpark.service.dto.member.returndto.MembersDto;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MemberControllerTest {

    private static final String MESSAGE = "At least one telephone number is required";

    @LocalServerPort
    private int port;

    @Autowired
    private KeycloakService keycloakService;
    @Autowired
    private MemberRepository repository;
    @Autowired
    private MemberController memberController;
    String url;
    String token;


    @BeforeAll
    void setUp() {
        url = "https://keycloak.switchfully.com/auth/realms/java-oct-2021/protocol/openid-connect/token";
        token = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("grant_type", "password")
                .formParam("username", "manager")
                .formParam("password", "password")
                .formParam("client_id", "GoatPark")
                .when()
                .post(url)
                .then()
                .extract()
                .path("access_token")
                .toString();
    }

    @Test
    void endToEnd_registerMember() {
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "DeleteMe", "password", "name",
                new CreateAddressDto("streetName", "5",
                        new CreatePostalCodeDto("code", "label")),
                new CreatePhoneNumberDto("0478", "757575"),
                new CreatePhoneNumberDto("0478", "757575"),
                new CreateEmailDto("test", "goat.com"),
                new CreateLicensePlateDto("goat-123", "BE"));

        RestAssured.defaultParser = Parser.JSON;
        PersonDto personDto = RestAssured
                .given()
                .body(createMemberDto)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/members")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(PersonDto.class);

        keycloakService.deleteUser(personDto.getKeycloakId());

        assertThat(personDto.getId()).isNotZero();
        assertThat(personDto.getName()).isEqualTo("name");
    }

    @Test
    void endToEnd_getAllMembers() {
        Person person = new Person(
                "end to end get all members",
                new PhoneNumber("0123", "451278"),
                new PhoneNumber("0478", "757575"),
                new EmailAddress("test", "goat.com"),
                new Address("streetName", "5",
                        new PostalCode("code", "label")),
                new Membership(
                        new LicensePlate("goat-123", "BE")));

        repository.registerMember(person);

        RestAssured.defaultParser = Parser.JSON;
        List<MembersDto> membersDtoList = RestAssured
                .given()
                .auth()
                .oauth2(token)
                .when()
                .port(port)
                .get("/members")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .jsonPath()
                .getList(".", MembersDto.class);

        assertThat(membersDtoList.stream().anyMatch(x -> x.getName().equals("end to end get all members"))).isTrue();
    }

    @Test
    void whenNoPhoneNumbers_thenExceptionIsThrown() {
        assertThatThrownBy(() -> memberController.register(
                new CreateMemberDto("uname", "pw", "name",
                        new CreateAddressDto("streetName", "5",
                                new CreatePostalCodeDto("code", "label")),
                        null,
                        null,
                        new CreateEmailDto("test", "goat.com"),
                        new CreateLicensePlateDto("goat-123", "BE"))))
                .isInstanceOf(PhoneNumberIsRequiredException.class)
                .hasMessage(MESSAGE);
    }
}