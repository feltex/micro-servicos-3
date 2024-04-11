package br.com.feltex.streamservice.filme;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface FilmeClient {

  @GetExchange("/filme/stream/{streamId}")
  List<StreamDto.Filme> findByStream(@PathVariable("streamId") Long streamId);

}
