package br.com.feltex.streamservice.filme;

import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

  private final LoadBalancedExchangeFilterFunction filterFunction;


  public WebClientConfig(LoadBalancedExchangeFilterFunction filterFunction) {
    this.filterFunction = filterFunction;
  }

  @Bean
  public WebClient filmeWebClient() {
    return WebClient.builder()
        .baseUrl("http://filme-service")
        .filter(filterFunction)
        .build();
  }

  @Bean
  public FilmeClient filmeClient() {
    final var httpServiceProxyFactory = HttpServiceProxyFactory
        .builder(WebClientAdapter.forClient(filmeWebClient()))
        .build();

    return httpServiceProxyFactory.createClient(FilmeClient.class);
  }


}
