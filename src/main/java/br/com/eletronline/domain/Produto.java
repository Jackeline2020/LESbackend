package br.com.eletronline.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "PRODUTO")
public class Produto extends Domain implements Serializable {

  private static final long serialVersionUID = -4443984822943051165L;

  @Id
  private Long id;

  private String descricao;

  private BigDecimal valor;

  private String marca;

  private String modelo;

  private String conteudoEmbalagem;

  private String garantia;

  private String peso;

  @ManyToOne
  @JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID")
  private Pedido pedido; // TODO corrigir ManyToMany
}
