package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class CidadeDTO implements Serializable {

  private static final long serialVersionUID = 6491781613632925377L;

  private Long id;

  private String nome;

  private EstadoDTO estado;
}
