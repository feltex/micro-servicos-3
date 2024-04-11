package br.com.feltex.filmeservice.domain;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
@Slf4j
public class FilmeController {

  private final FilmeRepository repository;

  public FilmeController(FilmeRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Filme add(@RequestBody Filme filme) {
    log.info("Filme add: {}", filme);
    return repository.add(filme);
  }

  @GetMapping
  public List<Filme> findAll() {
    log.info("Filme find");
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Filme findById(@PathVariable("id") Long id) {
    log.info("Filme find: id={}", id);
    return repository.findById(id);
  }

  @GetMapping("/stream/{streamId}")
  public List<Filme> findByStreamId(@PathVariable("streamId") Long streamId) {
    log.info("Filme find: streamId={}", streamId);
    return repository.findByStreamId(streamId);
  }

}
