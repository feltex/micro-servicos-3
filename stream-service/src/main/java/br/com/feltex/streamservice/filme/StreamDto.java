package br.com.feltex.streamservice.filme;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StreamDto {

  private Long id;
  private String nome;
  private List<Filme> filmes = new ArrayList<>();

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Filme {

    Long id;
    String nome;
    Long streamId;
    String descricao;
    Integer lancamento;
    Integer duracao;
  }

}
