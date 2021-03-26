package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class ProdutoDTO implements Serializable {

  private static final long serialVersionUID = -3082720688748086727L;

  private Long id;

  private String descricao;

  private BigDecimal valor;
  
  private String marca;

  private String modelo;
  
  private String conteudoEmbalagem;
  
  private String garantia;
  
  private String peso;

}
