package br.com.feltex.filmeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FilmeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(FilmeServiceApplication.class, args);
  }

}
