package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class EnderecoDTO implements Serializable {

  private static final long serialVersionUID = 6609807133416602342L;

  private Long id;

  private String cep;

  private String logradouro;

  private String numero;

  private String bairro;

  private String complemento;

  private Long tipoId;

  private Long cidadeId;

  private Long clienteId;
}
