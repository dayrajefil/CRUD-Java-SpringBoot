package br.com.JavaWebProgram.model;

import java.sql.Timestamp;

import br.com.JavaWebProgram.request.KindRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Entidade

@Table(name="kind")
@Entity(name="kind")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kind {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String named;
  private Timestamp created_at;
  private Timestamp updated_at;
  private Boolean active;

  public Kind(KindRequest kindRequest){
    this.named = kindRequest.named();
    this.active = true;
  }
}
