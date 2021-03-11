package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import br.com.eletronline.domain.FormaPagamentoType;
import br.com.eletronline.domain.Produto;
import br.com.eletronline.domain.StatusPedidoType;
import br.com.eletronline.domain.TipoEntregaType;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class PedidoDTO implements Serializable {

  private static final long serialVersionUID = -672274270142741719L;

  private Long id;

  private StatusPedidoType statusPedido;

  private LocalDate data;

  private FormaPagamentoType formaPagamento;

  private BigDecimal valor;

  private TipoEntregaType tipoEntrega;

  private BigDecimal valorEntrega;

  private CupomDTO cupom;

  private List<Produto> itens;

  private EnderecoDTO endereco;
}
