package br.com.JavaWebProgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;

import br.com.JavaWebProgram.model.Product;
import br.com.JavaWebProgram.repository.ProductRepository;
import br.com.JavaWebProgram.request.ProductRequest;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductRepository repository;

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> allProducts = repository.findAllByActiveTrue();
    if (allProducts.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(allProducts);
  }

  @PostMapping
  public ResponseEntity<Product> registerProduct(@RequestBody @Valid ProductRequest data){
    Product newProduct = new Product(data);
    repository.save(newProduct);
    return ResponseEntity.ok(newProduct);
  }

  @PutMapping
  @Transactional
  public ResponseEntity<Product> updateProduct(@RequestBody @Valid ProductRequest data){
    Optional<Product> optionalProduct = repository.findById(data.id());
    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();
      product.setKind_id(data.kind_id());
      product.setNamed(data.named());
      product.setRelate(data.relate());
      product.setUrl_link(data.url_link());
      product.setPrice(data.price());
      product.setActive(data.active());

      return ResponseEntity.ok(product);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Product> deleteProduct(@PathVariable Integer id){
    //repository.deleteById(id);
    //return ResponseEntity.noContent().build();

    Optional<Product> optionalProduct = repository.findById(id);
    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();
      product.setActive(false);

      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
