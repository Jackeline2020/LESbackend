package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class ClienteCadastroDTO implements Serializable {

  private static final long serialVersionUID = -6350200354780366086L;

  private String nome;

  private String email;

  private String senha;

  private Long tipoClienteId;
}
