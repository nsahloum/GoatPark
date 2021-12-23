package com.switchfully.goatpark.api;

import com.switchfully.goatpark.repository.division.DivisionRepository;
import com.switchfully.goatpark.service.division.DivisionService;
import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DivisionControllerTest {

    @LocalServerPort
    private int port;
    String url;
    String response;
    CreateDivisionDto createDivisionDto;

    @Autowired
    DivisionService divisionService;

    @Autowired
    DivisionRepository divisionRepository;

    @BeforeAll
    void setUp(){
        createDivisionDto = new CreateDivisionDto("testName", "OriginalName", "TestDirector", 0);
        url = "https://keycloak.switchfully.com/auth/realms/java-oct-2021/protocol/openid-connect/token";

        response = RestAssured
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
    void endToEnd_saveDivision() {
        RestAssured.defaultParser = Parser.JSON;
        DivisionDto divisionDto = RestAssured
                .given()
                .auth()
                .oauth2(response)
                .body(createDivisionDto)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .post("/divisions")
                .then()
                .assertThat().statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(DivisionDto.class);

        assertThat(divisionDto).isNotNull();
    }

    @Test
    void endToEnd_GetAllDivisions(){
        RestAssured.defaultParser = Parser.JSON;
        CreateDivisionDto createDivisionDto2 = new CreateDivisionDto("testName2", "OriginalName2", "TestDirector", null);
        divisionService.createDivision(createDivisionDto2);
        List<DivisionDto> divisionDto = RestAssured
                .given()
                .auth()
                .oauth2(response)
                .when()
                .port(port)
                .get("/divisions")
                .then()
                .assertThat().statusCode(HttpStatus.OK.value())
                .extract()
                .jsonPath()
                .getList(".", DivisionDto.class);

        assertThat(divisionDto).isNotEmpty();
    }



}