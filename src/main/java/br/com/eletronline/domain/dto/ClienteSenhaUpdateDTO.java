package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class ClienteSenhaUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String senha;
}
