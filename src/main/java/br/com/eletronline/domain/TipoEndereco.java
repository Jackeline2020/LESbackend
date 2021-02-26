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
@Table(name = "TIPO_ENDERECO")
public class TipoEndereco extends Domain implements Serializable {

  private static final long serialVersionUID = -4734108418181880764L;

  @Id
  private Long id;

  private String nome;

  private String descricao;
}
