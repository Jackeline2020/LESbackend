package br.com.eletronline.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "CONTATO")
public class Contato extends Domain implements Serializable {

  private static final long serialVersionUID = 818252785600370296L;

  @Id
  private Long id;

  private String ddd;

  private String numero;

  private Cliente cliente;
}
