package br.com.eletronline.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// @lombok.AllArgsConstructor
// @lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
// @Entity
// @Table(name = "PESSOA")
public abstract class Pessoa extends Domain {

  private static final long serialVersionUID = -2375505967408870895L;
  //
  // @GeneratedValue(
  // strategy = GenerationType.SEQUENCE,
  // generator = "SEQ_PESSOA")
  // @SequenceGenerator(
  // name = "SEQ_PESSOA",
  // sequenceName = "SEQ_PESSOA",
  // allocationSize = 1)
  // @Id
  // @Column(name = "ID", length = 8, nullable = false, updatable = false)
  // private Long id;

}
