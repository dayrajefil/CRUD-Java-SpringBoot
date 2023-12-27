package br.com.JavaWebProgram.model;

import java.sql.Timestamp;

import br.com.JavaWebProgram.request.ProductRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer kind_id;
  private String named;
  private String relate;
  private String url_link;
  private Timestamp created_at;
  private Timestamp updated_at;
  private Integer price;
  private Boolean active;


  public Product(ProductRequest productRequest){
    this.kind_id = productRequest.kind_id();
    this.named = productRequest.named();
    this.relate = productRequest.relate();
    this.url_link = productRequest.url_link();
    this.price = productRequest.price();
    this.active = true;
  }
}
