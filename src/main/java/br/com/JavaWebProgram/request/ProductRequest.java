package br.com.JavaWebProgram.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO - é um padrão de projeto de software usado para transferir dados entre subsistemas de um software.

public record ProductRequest(
  Integer id,
  @NotNull Integer kind_id,
  @NotBlank String named,
  @NotBlank String relate,
  @NotBlank String url_link,
  @NotNull Integer price,
  @NotNull Boolean active) {

}
