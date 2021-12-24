package com.switchfully.goatpark.api;

import com.switchfully.goatpark.domain.address.Address;
import com.switchfully.goatpark.domain.address.PostalCode;
import com.switchfully.goatpark.domain.parkinglot.Category;
import com.switchfully.goatpark.domain.parkinglot.ParkingLot;
import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.domain.person.emailaddress.EmailAddress;
import com.switchfully.goatpark.domain.person.phonenumber.PhoneNumber;
import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.repository.parkinglot.ParkingLotRepository;
import com.switchfully.goatpark.service.dto.parkingallocation.CreateParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkingallocation.ParkingAllocationDto;
import com.switchfully.goatpark.service.dto.parkinglot.CreateParkingLotDto;
import com.switchfully.goatpark.service.mapper.ParkingLotMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingSpotAllocationControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    private String keycloakToken;
    private CreateParkingAllocationDto createParkingAllocationDto;


    @BeforeAll
    public void setup() {
        CreateParkingLotDto createParkingLotDto = getCreateParkingLotDto();
        Person futureMember = new Person(
                "name",
                new PhoneNumber("0478", "757575"),
                new PhoneNumber("0478", "757575"),
                new EmailAddress("memberToBe", "goat.com"),
                new Address("streetName", "5", new PostalCode("code", "label")),
                null
        );

       futureMember = memberRepository.registerMember(futureMember);
        ParkingLot testParkingLot = parkingLotRepository.save(parkingLotMapper.mapCreateParkingLotDtoToParkingLot(createParkingLotDto));
       createParkingAllocationDto = new CreateParkingAllocationDto(futureMember.getId(), testParkingLot.getId());

        String url = "https://keycloak.switchfully.com/auth/realms/java-oct-2021/protocol/openid-connect/token";

        keycloakToken = RestAssured
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
    void endToEnd_CreateAParkingSpotAllocation() {
        RestAssured.defaultParser = Parser.JSON;
        ParkingAllocationDto parkingAllocationDto = RestAssured
                .given()
                .auth()
                .oauth2(keycloakToken)
                .body(createParkingAllocationDto)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .post("/parking-allocations")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ParkingAllocationDto.class);

        assertThat(parkingAllocationDto).isNotNull();
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