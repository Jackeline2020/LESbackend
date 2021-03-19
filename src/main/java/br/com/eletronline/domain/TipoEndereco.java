package br.com.eletronline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "TIPO_ENDERECO")
public class TipoEndereco extends Domain {

  private static final long serialVersionUID = -4734108418181880764L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_TIPO_ENDERECO")
  @SequenceGenerator(
      name = "SEQ_TIPO_ENDERECO", 
      sequenceName = "SEQ_TIPO_ENDERECO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "TIPO", length = 50)
  private String tipo; // TODO Enum
}
