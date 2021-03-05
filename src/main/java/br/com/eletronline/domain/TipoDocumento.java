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
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento extends Domain implements Serializable {

  private static final long serialVersionUID = -3774225721469053317L;

  @Id
  private Long id;

  private String descricao;

  private String nome; // TODO enum cpf e cnpj
}
