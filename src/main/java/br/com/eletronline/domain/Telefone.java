package br.com.eletronline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "TELEFONE")
public class Telefone extends Domain {

  private static final long serialVersionUID = 818252785600370296L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_CONTATO")
  @SequenceGenerator(
      name = "SEQ_CONTATO", 
      sequenceName = "SEQ_CONTATO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "DDD", length = 2)
  private String ddd;

  @Column(name = "NUMERO", length = 9)
  private String numero;

  @Column(name = "CLIENTE_ID", length = 8, insertable = false, updatable = false)
  private Long clienteId;

  @ManyToOne
  @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
  private Cliente cliente;
}
