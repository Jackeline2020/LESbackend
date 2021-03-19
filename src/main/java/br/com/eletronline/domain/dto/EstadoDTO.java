package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class EstadoDTO implements Serializable {

  private static final long serialVersionUID = -4330894770456541772L;

  private Long estadoId;

  private String nome;

  private String sigla;
}
