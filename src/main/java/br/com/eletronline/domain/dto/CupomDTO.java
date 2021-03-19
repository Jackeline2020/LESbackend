package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class CupomDTO implements Serializable {

  private static final long serialVersionUID = 3632133698424058043L;

  private Long cupomId;

  private String nome;

  private BigDecimal porcentagemDesconto;
}
