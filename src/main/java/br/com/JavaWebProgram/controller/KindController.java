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

import br.com.JavaWebProgram.model.Kind;
import br.com.JavaWebProgram.repository.KindRepository;
import br.com.JavaWebProgram.request.KindRequest;

@RestController
@RequestMapping("/kind")
public class KindController {

  @Autowired
  private KindRepository repository;

  @GetMapping
  public ResponseEntity<List<Kind>> getAllKinds(){
    List<Kind> allKinds = repository.findAllByActiveTrue();
    if (allKinds.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(allKinds);
  }

  @PostMapping
  public ResponseEntity<Kind> registerKind(@RequestBody @Valid KindRequest data){
    Kind newKind = new Kind(data);
    repository.save(newKind);
    return ResponseEntity.ok(newKind);
  }

  @PutMapping
  public ResponseEntity<Kind> updateKind(@RequestBody @Valid KindRequest data){
    Optional<Kind> optionalKind = repository.findById(data.id());
    if (optionalKind.isPresent()) {
      Kind kind = optionalKind.get();
      kind.setNamed(data.named());
      return ResponseEntity.ok(kind);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping
  @Transactional
  public ResponseEntity<Kind> updatekind(@RequestBody @Valid KindRequest data){
    Optional<Kind> optionalKind = repository.findById(data.id());
    if (optionalKind.isPresent()) {
      Kind kind = optionalKind.get();
      kind.setNamed(data.named());

      return ResponseEntity.ok(kind);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Kind> deleteKind(@PathVariable Integer id){
    Optional<Kind> optionalKind = repository.findById(id);
    if (optionalKind.isPresent()) {
      Kind kind = optionalKind.get();
      kind.setActive(false);

      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
