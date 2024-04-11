package br.com.feltex.filmeservice;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.feltex.filmeservice.domain.Filme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilmeServiceApplicationTests {


  @LocalServerPort
  private int serverPort;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void criar_ler_filme() {
    var filme = new Filme(1L, "O Poderoso Chefão", 1L,
        "Don Vito Corleone (Marlon Brando) é o chefe de uma famila de Nova York que está feliz...", 1970, 170);
    var request = new HttpEntity<>(filme);
    var url = "http://localhost:" + serverPort + "/filme";
    var postResponse = restTemplate.postForEntity(url, request, Filme.class);
    var postResponseBody = postResponse.getBody();
    assertAll(
        () -> assertEquals(HttpStatus.OK, postResponse.getStatusCode()),
        () -> assertEquals(filme.id(), postResponseBody.id())
    );

    var getResponse = restTemplate.getForEntity(url + "/" + postResponseBody.id(), Filme.class);
    assertAll(
        () -> assertEquals(HttpStatus.OK, getResponse.getStatusCode()),
        () -> assertEquals(postResponseBody, getResponse.getBody())
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
