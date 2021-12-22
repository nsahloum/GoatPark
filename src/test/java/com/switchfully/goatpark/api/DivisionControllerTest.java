package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.dto.division.CreateDivisionDto;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void endToEnd_saveDivision() {
        String url = "https://keycloak.switchfully.com/auth/realms/java-oct-2021/protocol/openid-connect/token";

        String response = RestAssured
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


        CreateDivisionDto createDivisionDto = new CreateDivisionDto("testName", "OriginalName", "TestDirector");
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

}