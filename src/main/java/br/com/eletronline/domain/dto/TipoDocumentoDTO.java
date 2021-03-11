package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class TipoDocumentoDTO implements Serializable {

  private static final long serialVersionUID = -3286106022884235157L;

  private Long id;

  private String descricao;

  private String nome; // TODO enum cpf e cnpj
}
