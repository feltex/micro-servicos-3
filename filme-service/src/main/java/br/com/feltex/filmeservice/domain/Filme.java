package br.com.feltex.filmeservice.domain;

public record Filme(Long id, String nome, Long streamId, String descricao, Integer lancamento, Integer duracao) {

}
