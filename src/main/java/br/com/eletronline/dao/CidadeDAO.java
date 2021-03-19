package br.com.eletronline.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cidade;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.repository.CidadeRepository;

@Component
public class CidadeDAO implements DAO {

  @Autowired private CidadeRepository cidadeRepository;

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
  public Cidade findById(final Long id) {
    final Cidade cidade = cidadeRepository.findById(id).orElse(null);
    return cidade;
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
