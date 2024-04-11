package br.com.feltex.streamservice.domain;

import br.com.feltex.streamservice.domain.model.Stream;
import br.com.feltex.streamservice.filme.FilmeClient;
import br.com.feltex.streamservice.filme.StreamDto;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
@Slf4j
public record StreamController(StreamRepository streamRepository, FilmeClient filmeClient) {


  @PostMapping
  public Stream salvar(@RequestBody Stream stream) {
    log.info("Salvando stream {}", stream);
    return streamRepository.save(stream);
  }

  @GetMapping
  public List<Stream> listar() {
    log.info("Listando todos os streams");
    return streamRepository.findAll();
  }

  @GetMapping("/{id}")
  public Stream findById(@PathVariable Long id) {
    log.info("Buscando stream por id {}", id);
    return streamRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Stream não encontrado")
    );
  }

  @GetMapping("/com-filmes")
  public List<StreamDto> findAllWithFilmes() {
    log.info("Carregando todos os Stream e filmes");

    var streams = streamRepository.findAll();
    var listaComFilmes = new ArrayList<StreamDto>();

    streams.forEach(item ->
        listaComFilmes.add(new StreamDto(item.getId(), item.getNome(), filmeClient.findByStream(item.getId())))
    );
    return listaComFilmes;
  }


}
