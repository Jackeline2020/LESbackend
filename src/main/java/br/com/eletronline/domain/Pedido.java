package br.com.eletronline.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "PEDIDO")
public class Pedido extends Domain implements Serializable {

  private static final long serialVersionUID = -6013071806891271899L;

  @Id
  private Long id;

  private StatusPedido statusPedido;

  private LocalDate data;

  private String formaPagamento; // ENUM

  private Cupom cupom;

  private BigDecimal valor;

  @OneToMany(mappedBy = "pedido")
  private List<Produto> itens;

  private TipoEntrega tipoEntrega;

  private BigDecimal valorEntrega;

  @JoinColumn(name = "ENDERECO_ID")
  private Endereco endereco;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
  private Cliente cliente;
}
