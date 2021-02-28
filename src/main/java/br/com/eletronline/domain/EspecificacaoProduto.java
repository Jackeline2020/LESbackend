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
@Table(name = "ESPECIFICAO_PRODUTO")
public class EspecificacaoProduto extends Domain implements Serializable {

  private static final long serialVersionUID = -1709612102951346829L;

  @Id
  private Long id;

  private String marca;

  private String modelo;

  private String conteudoEmbalagem;

  private String garantia;

  private String peso;
}
