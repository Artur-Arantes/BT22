package br.com.tiraboschi.bt22.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers(disabledWithoutDocker = true)
@DisplayName("Teste para integração de login")
public class LoginControllerIntegrationTest {

  @LocalServerPort
  private Integer port;

  public static final String ENV_DISABLE_TEST_CONTAIENRS = "DISABLE_TEST_CONTAIENRS";

  @Container
  public static Bt22DatabaseContainer container = Bt22DatabaseContainer
      .getInstance(StringUtils.isBlank(System.getenv(ENV_DISABLE_TEST_CONTAIENRS)));

  static {
    container.start();
  }

  @BeforeEach
  void setUp() {
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @Nested
  @DisplayName("testes para efetuar o login")
  class LoginTest {

    @Test
    @DisplayName("teste de login com sucesso")
    void testLoginSuccess() {
      RestAssured.given().contentType(ContentType.URLENC)
          .formParam("username", "admin")
          .formParam("password", "admin")
          .when()
          .post("/api/login")
          .then()
          .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("teste de login com falha")
    void testLoginFailure() {
      RestAssured.given().contentType(ContentType.URLENC)
          .formParam("username", "admin")
          .formParam("password", "x")
          .when()
          .post("/api/login")
          .then()
          .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
  }

}
