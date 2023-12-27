package br.com.JavaWebProgram.repository;

import br.com.JavaWebProgram.model.Product;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Consultas no Banco de Dados

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findAllByActiveTrue();
}
