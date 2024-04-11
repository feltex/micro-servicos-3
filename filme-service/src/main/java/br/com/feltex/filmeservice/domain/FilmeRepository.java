package br.com.feltex.filmeservice.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class FilmeRepository {

  private final Map<Long, Filme> filmes = new HashMap<>();

  public Filme add(Filme filme) {
    filmes.put(filme.id(), filme);
    return filme;
  }

  public Filme findById(Long id) {
    return filmes.computeIfAbsent(id, key -> {
      throw new RuntimeException("Filme não encontrado id=" + id);
    });
  }

  public List<Filme> findAll() {
    return filmes.values().stream().toList();
  }

  public List<Filme> findByStreamId(Long streamId) {
    return filmes.values().stream()
        .filter(f -> f.streamId().equals(streamId))
        .toList();
  }
}
