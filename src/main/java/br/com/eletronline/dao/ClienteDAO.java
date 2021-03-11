package br.com.eletronline.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.repository.ClienteRepository;
import br.com.eletronline.util.CriptografarSenha;

@Component
public class ClienteDAO implements DAO {

  @Autowired private ClienteRepository clienteRepository;

  @Autowired private CriptografarSenha criptografarSenha;

  @Override
  public String delete(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    clienteRepository.delete(cliente);
    return "Cliente excluído com sucesso!";
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    List<Cliente> clientes = new ArrayList<>();
    if (cliente.getId() != null) {
      clientes.add(findById(cliente.getId()));
    } else {
      clientes = findAll();
    }
    return clientes;
  }

  @Override
  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente findById(final Long id) {
    final Cliente cliente = clienteRepository.findById(id).orElse(null);
    return cliente;
  }

  public Optional<Cliente> findClienteByCPF(final String cpf) {
    final Example<Cliente> example = Example.of(Cliente.builder().nome(cpf).build());
    return clienteRepository.findOne(example);
  }

  public Optional<Cliente> findClienteByEmail(final String email) {
    final Example<Cliente> example = Example.of(Cliente.builder().email(email).build());
    return clienteRepository.findOne(example);
  }

  @Override
  public String save(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    cliente.setSenha(criptografarSenha.criptografar(cliente.getSenha()));
    clienteRepository.save(cliente);
    return "Cadastro realizado com sucesso!";
  }

  @Override
  public String update(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    cliente.setSenha(criptografarSenha.criptografar(cliente.getSenha()));
    clienteRepository.save(cliente);
    return "Cliente atualizado com sucesso!";
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
