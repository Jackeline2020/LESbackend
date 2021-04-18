package br.com.eletronline.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "FUNCIONARIO")
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Pessoa {

  private static final long serialVersionUID = -272785404035431529L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_FUNCIONARIO")
  @SequenceGenerator(
      name = "SEQ_FUNCIONARIO",
      sequenceName = "SEQ_FUNCIONARIO",
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

  @OneToMany(mappedBy = "funcionario")
  private List<Documento> documentos;
}
