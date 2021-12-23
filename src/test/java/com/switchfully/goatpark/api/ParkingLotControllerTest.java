package com.switchfully.goatpark.api;

import com.switchfully.goatpark.repository.parkinglot.ParkingLotRepository;
import com.switchfully.goatpark.service.domain.address.Address;
import com.switchfully.goatpark.service.domain.address.PostalCode;
import com.switchfully.goatpark.service.domain.parkinglot.Category;
import com.switchfully.goatpark.service.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.service.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotDto;
import com.switchfully.goatpark.service.dto.parkinglot.ParkingLotOverviewDto;
import com.switchfully.goatpark.service.mapper.ParkingLotMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingLotControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

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

    @Test
    void endToEnd_GetAllParkingLots() {
        ParkingLot parkingLot = new ParkingLot.ParkingLotBuilder()
                .withCategory(createParkingLotDto.getCategory())
                .withName(createParkingLotDto.getName())
                .withContactPerson(createParkingLotDto.getContactPerson())
                .withPricePerHour(createParkingLotDto.getPricePerHour())
                .withMaximumCapacity(createParkingLotDto.getMaximumCapacity())
                .withAddress(createParkingLotDto.getAddress()).build();

        ParkingLot saved = parkingLotRepository.save(parkingLot);
        RestAssured.defaultParser = Parser.JSON;
        ParkingLotOverviewDto[] parkinglotArray = RestAssured
                .given()
                .auth()
                .oauth2(keycloakToken)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .get("/parkinglots")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(ParkingLotOverviewDto[].class);

        assertThat(Arrays.stream(parkinglotArray)
                .anyMatch(x -> x.getId() == parkingLotMapper.mapParkingLotToParkingLotOverviewDto(saved).getId()))
                .isTrue();
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