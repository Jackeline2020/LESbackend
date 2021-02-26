package br.com.eletronline.domain;

import java.util.List;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
public abstract class Pessoa extends Domain {

  private List<Documento> documentos;
}
