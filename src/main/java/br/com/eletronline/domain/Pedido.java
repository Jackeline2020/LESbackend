package br.com.eletronline.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "PEDIDO")
public class Pedido extends Domain {

  private static final long serialVersionUID = -6013071806891271899L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_PEDIDO")
  @SequenceGenerator(
      name = "SEQ_PEDIDO", 
      sequenceName = "SEQ_PEDIDO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "STATUS_PEDIDO", length = 80)
  private StatusPedidoType statusPedido;

  @Column(name = "DATA")
  private LocalDate data;

  @Column(name = "FORMA_PAGAMENTO", length = 50)
  private FormaPagamentoType formaPagamento;

  @Column(name = "VALOR")
  private BigDecimal valor;

  @Column(name = "TIPO_ENTREGA", length = 50)
  private TipoEntregaType tipoEntrega;

  @Column(name = "VALOR_ENTREGA")
  private BigDecimal valorEntrega;

  @ManyToOne
  @JoinColumn(name = "CUPOM_ID", referencedColumnName = "ID")
  private Cupom cupom;

  @ManyToMany
  @JoinTable(
      name = "PEDIDOS_PRODUTOS",
      joinColumns = @JoinColumn(name = "PEDIDO_ID"),
      inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID"))
  private List<Produto> itens;

  @ManyToOne
  @JoinColumn(name = "ENDERECO_ID", referencedColumnName = "ID")
  private Endereco endereco;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
  private Cliente cliente;
}
