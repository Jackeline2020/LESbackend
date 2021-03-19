package br.com.eletronline.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.TipoDocumento;
import br.com.eletronline.repository.TipoDocumentoRepository;

@Component
public class TipoDocumentoDAO implements DAO {

  @Autowired private TipoDocumentoRepository tipoDocumentoRepository;

  @Override
  public String delete(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> find(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<? extends Domain> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TipoDocumento findById(final Long id) {
    final TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id).orElse(null);
    return tipoDocumento;
  }

  @Override
  public String save(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String update(Domain domain) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
