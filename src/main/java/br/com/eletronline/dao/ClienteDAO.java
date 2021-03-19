package br.com.eletronline.dao;

import static java.util.Objects.nonNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.repository.ClienteRepository;
import br.com.eletronline.repository.DocumentoRepository;
import br.com.eletronline.repository.EnderecoRepository;
import br.com.eletronline.repository.TelefoneRepository;
import br.com.eletronline.util.CriptografarSenha;

@Component
public class ClienteDAO implements DAO {

  @Autowired private ClienteRepository clienteRepository;

  @Autowired private DocumentoRepository documentoRepository;

  @Autowired private EnderecoRepository enderecoRepository;

  @Autowired private TelefoneRepository telefoneRepository;

  @Autowired private CriptografarSenha criptografarSenha;

  @Override
  public String delete(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    final Cliente clienteEncontrado = clienteRepository.findById(cliente.getId()).orElse(null);
    if (nonNull(clienteEncontrado)) {
      if (nonNull(clienteEncontrado.getDocumentos())) {
        documentoRepository.deleteAll(clienteEncontrado.getDocumentos());
      }
      if (nonNull(clienteEncontrado.getEnderecos())) {
        enderecoRepository.deleteAll(clienteEncontrado.getEnderecos());
      }
      if (nonNull(clienteEncontrado.getTelefones())) {
        telefoneRepository.deleteAll(clienteEncontrado.getTelefones());
      }
      clienteRepository.delete(clienteEncontrado);
      return "Cliente excluído com sucesso!";
    } else {
      return "Erro interno do sistema! Cliente não encontrado!";
    }
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
    final Cliente cliente = Cliente.builder().email(email).build();
    return clienteRepository.findOne(Example.of(cliente));
  }

  @Override
  public String save(final Domain domain) {
    final Cliente cliente = (Cliente) domain;
    cliente.setSenha(criptografarSenha.criptografar(cliente.getSenha()));
    cliente.setDataCadastro(LocalDate.now());
    clienteRepository.save(cliente);
    return "Cadastro realizado com sucesso!";
  }

  @Override
  public String update(final Domain domain) {
    final Cliente clienteUpdate = (Cliente) domain;
    final Cliente cliente = clienteRepository.findById(clienteUpdate.getId()).orElse(null);
    if (nonNull(cliente)) {
      cliente.setNome(clienteUpdate.getNome() != null ? clienteUpdate.getNome() : cliente.getNome());
      cliente.setEmail(clienteUpdate.getEmail() != null ? clienteUpdate.getEmail() : cliente.getEmail());
      cliente.setSenha(clienteUpdate.getSenha() != null ?
          criptografarSenha.criptografar(clienteUpdate.getSenha())
          : cliente.getSenha());
      clienteRepository.save(cliente);
      return "Cliente atualizado com sucesso!";
    } else {
      return "Erro interno do sistema! Cliente não encontrado para atualização!";
    }
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }
}
