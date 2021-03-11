package br.com.eletronline.domain;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CUPOM")
public class Cupom extends Domain {

  private static final long serialVersionUID = -9122810387531033749L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_CUPOM")
  @SequenceGenerator(
      name = "SEQ_CUPOM", 
      sequenceName = "SEQ_CUPOM",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "NOME", length = 30)
  private String nome;

  @Column(name = "PORCENTAGEM_DESCONTO")
  private BigDecimal porcentagemDesconto;

  @OneToMany(mappedBy = "cupom")
  private List<Pedido> pedidos;
}
