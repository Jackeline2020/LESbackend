package br.com.eletronline.domain.dto;

import java.io.Serializable;
import java.util.List;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public abstract class PessoaDTO implements Serializable {

  private static final long serialVersionUID = -637796505640975500L;

  private List<DocumentoDTO> documentos;
}
