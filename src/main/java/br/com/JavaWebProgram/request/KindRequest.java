package br.com.JavaWebProgram.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO - é um padrão de projeto de software usado para transferir dados entre subsistemas de um software.

public record KindRequest(
  Integer id,
  @NotBlank String named,
  @NotNull Boolean active) {
}
