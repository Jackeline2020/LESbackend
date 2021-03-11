package br.com.eletronline.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class Domain implements Serializable {

  private static final long serialVersionUID = -1964351118993561605L;

  @Id
  @Column(name = "ID")
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DATA_CADASTRO")
  private Date dataCadastro;
}
