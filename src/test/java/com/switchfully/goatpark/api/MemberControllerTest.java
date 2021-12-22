package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.dto.member.create.*;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void endToEnd_registerMember() {

        CreateMemberDto createMemberDto = new CreateMemberDto("username", "password", "name",
                new CreateAddressDto("streetName", "streetNumber",
                        new CreatePostalCodeDto("code", "label")),
                new CreatePhoneNumberDto("0478", "757575"),
                new CreatePhoneNumberDto("0478", "757575"),
                new CreateEmailDto("test", "goat.com"),
                new CreateLicensePlateDto("goat-123", "BE"));

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

        assertThat(personDto.getId()).isNotZero();
        assertThat(personDto.getName()).isEqualTo("name");
    }

}