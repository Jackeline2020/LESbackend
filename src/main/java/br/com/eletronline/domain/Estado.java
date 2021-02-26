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
@Table(name = "ESTADO")
public class Estado extends Domain implements Serializable {

  private static final long serialVersionUID = 6349913294381137683L;

  @Id
  private Long id;

  private String descricao;
}
