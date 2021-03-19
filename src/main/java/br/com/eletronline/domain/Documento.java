package br.com.eletronline.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@lombok.Builder
@Entity
@Table(name = "DOCUMENTO")
public class Documento extends Domain {

  private static final long serialVersionUID = 8293181859869819159L;

  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "SEQ_DOCUMENTO")
  @SequenceGenerator(
      name = "SEQ_DOCUMENTO", 
      sequenceName = "SEQ_DOCUMENTO",
      allocationSize = 1)
  @Id
  @Column(name = "ID", length = 8, nullable = false, updatable = false)
  private Long id;

  @Column(name = "NUMERO_DOCUMENTO", length = 30)
  private String numero;

  @Column(name = "VALIDADE")
  private LocalDate validade;

  @ManyToOne
  @JoinColumn(name = "TIPO_DOCUMENTO_ID", referencedColumnName = "ID")
  private TipoDocumento tipo;

  @ManyToOne
  @JoinTable(
      name = "CLIENTE_DOCUMENTO",
      joinColumns = @JoinColumn(name = "DOCUMENTO_ID"),
      inverseJoinColumns = @JoinColumn(name = "CLIENTE_ID"))
  private Cliente cliente;

  @ManyToOne
  @JoinTable(
      name = "FUNCIONARIO_DOCUMENTO",
      joinColumns = @JoinColumn(name = "DOCUMENTO_ID"),
      inverseJoinColumns = @JoinColumn(name = "FUNCIONARIO_ID"))
  private Funcionario funcionario;
}
