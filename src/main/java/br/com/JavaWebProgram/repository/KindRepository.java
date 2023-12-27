package br.com.JavaWebProgram.repository;

import br.com.JavaWebProgram.model.Kind;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Consultas no Banco de Dados

public interface KindRepository extends JpaRepository<Kind, Integer> {
  List<Kind> findAllByActiveTrue();
}
