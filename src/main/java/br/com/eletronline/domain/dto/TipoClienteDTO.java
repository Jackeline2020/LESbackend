package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class TipoClienteDTO implements Serializable {

  private static final long serialVersionUID = -6832571448664912838L;

  private Long id;

  private String nome;

  private String descricao;
}
