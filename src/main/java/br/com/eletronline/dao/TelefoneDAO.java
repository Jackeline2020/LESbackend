package br.com.eletronline.dao;

import static java.util.Objects.nonNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Telefone;
import br.com.eletronline.repository.TelefoneRepository;

@Component
public class TelefoneDAO implements DAO {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private TelefoneRepository telefoneRepository;

  @Override
  public String delete(final Domain domain) {
    final Telefone telefone = (Telefone) domain;
    final Telefone telefoneEncontrado = telefoneRepository.findById(telefone.getId()).orElse(null);
    if (nonNull(telefoneEncontrado)) {
      telefoneRepository.delete(telefoneEncontrado);
      return "Telefone excluído com sucesso!";
    } else {
      return "Erro interno do sistema! Telefone não encontrado!";
    }
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    final Telefone telefone = (Telefone) domain;
    List<Telefone> telefones = new ArrayList<>();
    if (telefone.getId() != null) {
      telefones.add(findById(telefone.getId()));
    } else {
      telefones = findAll();
    }
    return telefones;
  }

  @Override
  public List<Telefone> findAll() {
    return telefoneRepository.findAll();
  }

  @Override
  public Telefone findById(final Long id) {
    final Telefone telefone = telefoneRepository.findById(id).orElse(null);
    return telefone;
  }

  @Override
  public String save(final Domain domain) {
    final Telefone telefone = (Telefone) domain;
    final Cliente cliente = clienteDAO.findById(telefone.getCliente().getId());
    if (nonNull(cliente)) {
      telefone.setCliente(cliente);
      telefone.setDataCadastro(LocalDate.now());
      telefoneRepository.save(telefone);
      return "Endereço cadastrado com sucesso!";
    } else {
      return "Erro interno do sistema! Cliente não encontrado!";
    }
  }

  @Override
  public String update(final Domain domain) {
    final Telefone telefoneUpdate = (Telefone) domain;
    final Telefone telefone = telefoneRepository.findById(telefoneUpdate.getId()).orElse(null);
    if (nonNull(telefone)) {
      telefone.setDdd(telefoneUpdate.getDdd() != null ? telefoneUpdate.getDdd() : telefone.getDdd());
      telefone.setNumero(telefoneUpdate.getNumero() != null ? telefoneUpdate.getNumero() : telefone.getNumero());
      telefoneRepository.save(telefone);
      return "Telefone atualizado com sucesso!";
    } else {
      return "Erro interno do sistema! Telefone não encontrado!";
    }
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
