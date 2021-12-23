package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.address.PostalCode;
import com.switchfully.goatpark.service.domain.parkinglot.Category;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingLotControllerTest {

    @LocalServerPort
    private int port;

    private String keycloakToken;
    private CreateParkingLotDto createParkingLotDto;

    @BeforeAll
    public void setup() {
        createParkingLotDto = getCreateParkingLotDto();
        String url = "https://keycloak.switchfully.com/auth/realms/java-oct-2021/protocol/openid-connect/token";

        keycloakToken = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("grant_type", "password")
                .formParam("username", "manager1")
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
    void endToEnd_AddParkingLot() {
        RestAssured.defaultParser = Parser.JSON;
        ParkingLotDto parkingLotDto = RestAssured
                .given()
                .auth()
                .oauth2(keycloakToken)
                .body(createParkingLotDto)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .post("/parkinglots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ParkingLotDto.class);

        assertThat(parkingLotDto).isNotNull();
    }

    private Person getPersonForTesting() {
        return new Person(
                "name",
                new PhoneNumber("0478", "757575"),
                new PhoneNumber("0478", "757575"),
                new EmailAddress("test", "goat.com"),
                new Address("streetName", "5", new PostalCode("code", "label")),
                null
        );
    }

    private CreateParkingLotDto getCreateParkingLotDto() {
        return new CreateParkingLotDto(
                "Parking Goat",
                Category.UNDERGROUND_BUILDING,
                500,
                getPersonForTesting(),
                new Address("streetName", "5", new PostalCode("code", "label")),
                14.7);
    }

}