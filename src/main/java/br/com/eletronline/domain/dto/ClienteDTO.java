package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class ClienteDTO extends PessoaDTO implements Serializable {

  private static final long serialVersionUID = -6350200354780366086L;

  private Long clienteId;

  private String nome;

  private String email;

  private String senha;

  private String tipoNome;

  private List<DocumentoDTO> documentos;
}
