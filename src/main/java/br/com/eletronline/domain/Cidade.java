package br.com.eletronline.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CIDADE")
public class Cidade extends Domain implements Serializable {

  private static final long serialVersionUID = -3259270784505968534L;

  @Id
  private Long id;

  private String descricao;

  private Estado estado;
}
