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
@Table(name = "ESTADO")
public class Estado extends Domain {

  private static final long serialVersionUID = 6349913294381137683L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_ESTADO")
  @SequenceGenerator(
      name = "SEQ_ESTADO", 
      sequenceName = "SEQ_ESTADO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "NOME", length = 100)
  private String nome;

  @Column(name = "SIGLA", length = 2)
  private String sigla;

  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades;
}
