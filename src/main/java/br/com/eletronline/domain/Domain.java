package br.com.eletronline.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@lombok.Getter
@lombok.Setter
public class Domain implements Serializable {

  private static final long serialVersionUID = -1964351118993561605L;

  @Column(name = "DATA_CADASTRO")
  private LocalDate dataCadastro;
}
