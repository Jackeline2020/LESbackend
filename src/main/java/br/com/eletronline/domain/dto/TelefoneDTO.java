package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class TelefoneDTO implements Serializable {

  private static final long serialVersionUID = -3082720688748086727L;

  private Long id;

  private String ddd;

  private String numero;

  private Long clienteId;
}
