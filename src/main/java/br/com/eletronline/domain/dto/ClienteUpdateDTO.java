package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class ClienteUpdateDTO extends PessoaDTO implements Serializable {

  private static final long serialVersionUID = 5638885797982867316L;

  private String nome;

  private String email;

  private String senha;
}
