package br.com.eletronline.domain;

import java.io.Serializable;
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
@Table(name = "ENDERECO")
public class Endereco extends Domain implements Serializable {

  private static final long serialVersionUID = 569462439003858338L;

  @Id
  private Long id;

  private String cep;

  private String logradouro;

  private String numero;

  private String bairro;

  private String complemento;

  private Cidade cidade; // TODO finalizar relacionamento

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
  private Cliente cliente;

  // TODO tipoEndereco
}
