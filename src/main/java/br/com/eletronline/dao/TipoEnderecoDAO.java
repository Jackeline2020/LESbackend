package br.com.eletronline.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.TipoEndereco;
import br.com.eletronline.repository.TipoEnderecoRepository;

@Component
public class TipoEnderecoDAO implements DAO {

  @Autowired private TipoEnderecoRepository tipoEnderecoRepository;

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
  public TipoEndereco findById(final Long id) {
    final TipoEndereco tipoEndereco = tipoEnderecoRepository.findById(id).orElse(null);
    return tipoEndereco;
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
