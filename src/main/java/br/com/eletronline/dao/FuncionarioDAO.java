package br.com.eletronline.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Funcionario;
import br.com.eletronline.repository.FuncionarioRepository;

@Component
public class FuncionarioDAO implements DAO {

  @Autowired private FuncionarioRepository funcionarioRepository;

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
  public Domain findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  public Optional<Funcionario> findFuncionarioByEmail(final String email) {
    final Funcionario funcionario = Funcionario.builder().email(email).build();
    return funcionarioRepository.findOne(Example.of(funcionario));
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
