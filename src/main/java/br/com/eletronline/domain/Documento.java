package br.com.eletronline.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "DOCUMENTO")
public class Documento extends Domain implements Serializable {

  private static final long serialVersionUID = 8293181859869819159L;

  @Id
  private Long id;

  private String codigo;

  private LocalDate validade;

  private TipoDocumento tipoDocumento;
}
