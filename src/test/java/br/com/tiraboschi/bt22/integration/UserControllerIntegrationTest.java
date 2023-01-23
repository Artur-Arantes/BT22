package br.com.tiraboschi.bt22.integration;

import br.com.tiraboschi.bt22.model.dto.output.UserOutputDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.testcontainers.junit.jupiter.Container;

import java.util.Map;

public class UserControllerIntegrationTest extends BaseControllerIntegrationTest {
  private String token;

  private Map<String, String> headers;

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
    token = getToken();
    headers = Map.of(
        "Authorization", "Bearer " + token,
        "Content-Type", "application/json"
    );
  }

  @DisplayName("Criando usuário")
  @Nested
  class Create {
    final UserOutputDto resposta = (UserOutputDto) RestAssured.given()
        .formParam("aaa","11")
        .get("/api/user")
        .then()
        .statusCode(HttpStatus.OK.value());
  }

}

