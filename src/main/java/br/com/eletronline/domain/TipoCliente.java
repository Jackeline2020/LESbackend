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
@Table(name = "TIPO_CLIENTE")
public class TipoCliente extends Domain implements Serializable {

  private static final long serialVersionUID = 1864686864329703485L;

  @Id
  private Long id;

  private String nome;

  private String descricao;
}
