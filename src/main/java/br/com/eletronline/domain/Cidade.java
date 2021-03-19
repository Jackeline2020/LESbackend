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
@Table(name = "CIDADE")
public class Cidade extends Domain {

  private static final long serialVersionUID = -3259270784505968534L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_CIDADE")
  @SequenceGenerator(
      name = "SEQ_CIDADE", 
      sequenceName = "SEQ_CIDADE",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8)
  private Long id;

  @Column(name = "NOME", length = 100)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ID")
  private Estado estado;
}
