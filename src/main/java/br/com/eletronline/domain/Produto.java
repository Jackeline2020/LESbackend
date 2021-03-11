package br.com.eletronline.domain;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "PRODUTO")
public class Produto extends Domain {

  private static final long serialVersionUID = -4443984822943051165L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_PRODUTO")
  @SequenceGenerator(
      name = "SEQ_PRODUTO", 
      sequenceName = "SEQ_PRODUTO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "DESCRICAO", length = 200)
  private String descricao;

  @Column(name = "VALOR")
  private BigDecimal valor;

  @Column(name = "MARCA", length = 50)
  private String marca;

  @Column(name = "MODELO", length = 80)
  private String modelo;

  @Column(name = "CONTEUDO_EMBALAGEM", length = 100)
  private String conteudoEmbalagem;

  @Column(name = "GARANTIA", length = 40)
  private String garantia;

  @Column(name = "PESO", length = 40)
  private String peso;

  @ManyToMany(mappedBy = "itens")
  private List<Pedido> pedidos;
}
