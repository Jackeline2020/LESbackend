package br.com.eletronline.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "ENDERECO")
public class Endereco extends Domain {

  private static final long serialVersionUID = 569462439003858338L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_ENDERECO")
  @SequenceGenerator(
      name = "SEQ_ENDERECO",
      sequenceName = "SEQ_ENDERECO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "CEP", length = 8)
  private String cep;

  @Column(name = "LOGRADOURO", length = 50)
  private String logradouro;

  @Column(name = "NUMERO", length = 5)
  private String numero;

  @Column(name = "BAIRRO", length = 80)
  private String bairro;

  @Column(name = "COMPLEMENTO", length = 30)
  private String complemento;

  @OneToOne
  @JoinColumn(name = "TIPO_ENDERECO_ID", referencedColumnName = "ID")
  private TipoEndereco tipo;

  @OneToOne
  @JoinColumn(name = "CIDADE_ID", referencedColumnName = "ID")
  private Cidade cidade;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
  private Cliente cliente;

  @OneToMany(mappedBy = "endereco")
  private List<Pedido> pedidos;
}
