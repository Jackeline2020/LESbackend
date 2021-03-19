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
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento extends Domain {

  private static final long serialVersionUID = -3774225721469053317L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_TIPO_DOCUMENTO")
  @SequenceGenerator(
      name = "SEQ_TIPO_DOCUMENTO", 
      sequenceName = "SEQ_TIPO_DOCUMENTO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "DESCRICAO", length = 200)
  private String descricao;

  @Column(name = "NOME", length = 100)
  private String nome; // TODO enum

  @OneToMany(mappedBy = "tipo")
  private List<Documento> documentos;
}
