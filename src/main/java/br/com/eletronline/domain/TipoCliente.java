package br.com.eletronline.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "TIPO_CLIENTE")
public class TipoCliente extends Domain {

  private static final long serialVersionUID = 1864686864329703485L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_TIPO_CLIENTE")
  @SequenceGenerator(
      name = "SEQ_TIPO_CLIENTE", 
      sequenceName = "SEQ_TIPO_CLIENTE",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "NOME", length = 100)
  private String nome;

  @Column(name = "DESCRICAO", length = 200)
  private String descricao;

  @OneToMany(mappedBy = "tipoCliente")
  private List<Cliente> clientes;
}
