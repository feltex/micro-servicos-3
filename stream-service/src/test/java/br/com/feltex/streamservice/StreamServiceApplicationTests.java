package br.com.feltex.streamservice;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.feltex.streamservice.domain.model.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StreamServiceApplicationTests {

  @LocalServerPort
  private int serverPort;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void createAndGetDepartment() {
    // Criando um stream
    var stream = new Stream(1L, "Information Technology");
    var request = new HttpEntity<>(stream);
    var url = "http://localhost:" + serverPort + "/stream";
    var postResponse = restTemplate.postForEntity(url, request, Stream.class);
    var departmentResult = postResponse.getBody();
    assertAll(
        () -> assertEquals(HttpStatus.OK, postResponse.getStatusCode()),
        () -> assertEquals(stream.getId(), departmentResult.getId())
    );

    // Lendo um stream
    var getResponse = restTemplate.getForEntity(url + "/" + departmentResult.getId(), Stream.class);
    assertAll(
        () -> assertEquals(HttpStatus.OK, getResponse.getStatusCode()),
        () -> assertEquals(departmentResult, getResponse.getBody())
    );
  }


  @Test
  void validateHealth() {
    var url = "http://localhost:" + serverPort + "/actuator/health";
    var postResponse = restTemplate.getForEntity(url, String.class);
    assertAll(
        () -> assertEquals(HttpStatus.OK, postResponse.getStatusCode()),
        () -> assertEquals("""
            {"status":"UP"}""", postResponse.getBody())
    );
  }

}
