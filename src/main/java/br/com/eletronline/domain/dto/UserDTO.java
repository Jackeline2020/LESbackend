package br.com.eletronline.domain.dto;

import java.io.Serializable;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class UserDTO implements Serializable {

  private static final long serialVersionUID = 8686362799307486737L;

  private String email;

  private String senha;
}
