package br.com.eletronline.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CUPOM")
public class Cupom extends Domain implements Serializable {

  private static final long serialVersionUID = -9122810387531033749L;

  @Id
  private Long id;

  private String nome;

  private BigDecimal porcentagemDesconto;
}
