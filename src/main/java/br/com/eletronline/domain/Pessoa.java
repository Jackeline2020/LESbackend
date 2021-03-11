package br.com.eletronline.domain;

import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Getter
@lombok.Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "PESSOA")
public abstract class Pessoa extends Domain {

  private static final long serialVersionUID = -2375505967408870895L;

  @OneToMany(mappedBy = "pessoa")
  private List<Documento> documentos;
}
