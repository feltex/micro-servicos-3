package br.com.feltex.serviceregistry;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceRegistryApplicationTests {


  @LocalServerPort
  private int serverPort;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void validateHealth() {
    var expectedOutput = """
        {"status":"UP"}""";

    var url = "http://localhost:" + serverPort + "/actuator/health";
    var postResponse = restTemplate.getForEntity(url, String.class);
    assertAll(
        () -> assertEquals(HttpStatus.OK, postResponse.getStatusCode()),
        () -> assertEquals(expectedOutput, postResponse.getBody())
    );
  }

}
