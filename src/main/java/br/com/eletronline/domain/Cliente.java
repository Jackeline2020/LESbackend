package br.com.eletronline.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CLIENTE")
public class Cliente extends Pessoa implements Serializable {

  private static final long serialVersionUID = 141314329529499228L;

  @Id
  private Long id;

  private String nome;

  private TipoCliente tipoCliente;

  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos;

  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos;
}
