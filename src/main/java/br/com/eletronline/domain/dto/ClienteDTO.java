package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class ClienteDTO extends PessoaDTO implements Serializable {

  private static final long serialVersionUID = -6350200354780366086L;

  private Long id;

  private String nome;

  private String email;

  private TipoClienteDTO tipoCliente;
}
