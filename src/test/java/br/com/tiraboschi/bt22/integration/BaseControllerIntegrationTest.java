package br.com.tiraboschi.bt22.integration;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;

public abstract class BaseControllerIntegrationTest {

  public final static Faker FAKER = Faker.instance();

  public String getToken() {
    String token = RestAssured.given().contentType(ContentType.URLENC)
        .formParam("username", "admin")
        .formParam("password", "admin")
        .when()
        .post("/api/login")
        .then()
        .statusCode(HttpStatus.OK.value())
        .extract().jsonPath()
        .getObject("accessToken", String.class);
    return token;
  }

}