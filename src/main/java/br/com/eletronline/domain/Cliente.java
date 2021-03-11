package br.com.eletronline.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CLIENTE")
@DiscriminatorValue("CLIENTE")
public class Cliente extends Pessoa {

  private static final long serialVersionUID = 141314329529499228L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_CLIENTE")
  @SequenceGenerator(
      name = "SEQ_CLIENTE", 
      sequenceName = "SEQ_CLIENTE",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "NOME", length = 100)
  private String nome;

  @Column(name = "EMAIL", length = 100)
  private String email;

  @Column(name = "SENHA", length = 40)
  private String senha;

//  @Column(name = "TIPO_CLIENTE_ID", length = 8, insertable = false, updatable = false)
//  private Long tipoClienteId;

  @ManyToOne
  @JoinColumn(name = "TIPO_CLIENTE_ID", referencedColumnName = "ID")
  private TipoCliente tipoCliente;

  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos;

  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos;

  @OneToMany(mappedBy = "cliente")
  private List<Telefone> telefones;
}
