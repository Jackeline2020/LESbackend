package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class DocumentoDTO implements Serializable {

  private static final long serialVersionUID = -621053826039631478L;

  private Long id;

  private String numero;

  private LocalDate validade;

  private String tipoNome;
}
