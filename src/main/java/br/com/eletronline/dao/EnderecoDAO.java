package br.com.eletronline.dao;

import static java.util.Objects.nonNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Cidade;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Endereco;
import br.com.eletronline.domain.TipoEndereco;
import br.com.eletronline.repository.EnderecoRepository;

@Component
public class EnderecoDAO implements DAO {

  @Autowired private CidadeDAO cidadeDAO;

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private TipoEnderecoDAO tipoEnderecoDAO;

  @Autowired private EnderecoRepository enderecoRepository;

  @Override
  public String delete(final Domain domain) {
    final Endereco endereco = (Endereco) domain;
    final Endereco enderecoEncontrado = enderecoRepository.findById(endereco.getId()).orElse(null);
    if (nonNull(enderecoEncontrado)) {
      enderecoRepository.delete(enderecoEncontrado);
      return "Endereço excluído com sucesso!";
    } else {
      return "Erro interno do sistema! Endereço não encontrado!";
    }
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    final Endereco endereco = (Endereco) domain;
    List<Endereco> enderecos = new ArrayList<>();
    if (endereco.getId() != null) {
      enderecos.add(findById(endereco.getId()));
    } else {
      enderecos = findAll();
    }
    return enderecos;
  }

  @Override
  public List<Endereco> findAll() {
    return enderecoRepository.findAll();
  }

  @Override
  public Endereco findById(final Long id) {
    final Endereco endereco = enderecoRepository.findById(id).orElse(null);
    return endereco;
  }

  @Override
  public String save(final Domain domain) {
    final Endereco endereco = (Endereco) domain;
    final Cliente cliente = clienteDAO.findById(endereco.getCliente().getId());
    if (nonNull(cliente)) {
      final Cidade cidade = cidadeDAO.findById(endereco.getCidade().getId());
      if (nonNull(cidade)) {
        endereco.setCidade(cidade);
        endereco.setCliente(cliente);
        endereco.setDataCadastro(LocalDate.now());
        enderecoRepository.save(endereco);
        return "Endereço cadastrado com sucesso!";
      } else {
        return "Erro interno do sistema! Cidade não encontrada!";
      }
    } else {
      return "Erro interno do sistema! Cliente não encontrado!";
    }
  }

  @Override
  public String update(final Domain domain) {
    final Endereco enderecoUpdate = (Endereco) domain;
    final Endereco endereco = enderecoRepository.findById(enderecoUpdate.getId()).orElse(null);
    if (nonNull(endereco)) {
      endereco.setCep(enderecoUpdate.getCep() != null ? enderecoUpdate.getCep() : endereco.getCep());
      endereco.setLogradouro(enderecoUpdate.getLogradouro() != null ? enderecoUpdate.getLogradouro() : endereco.getLogradouro());
      endereco.setNumero(enderecoUpdate.getNumero() != null ? enderecoUpdate.getNumero() : endereco.getNumero());
      endereco.setBairro(enderecoUpdate.getBairro() != null ? enderecoUpdate.getBairro() : endereco.getBairro());
      endereco.setComplemento(enderecoUpdate.getComplemento() != null ? enderecoUpdate.getComplemento() : endereco.getComplemento());
      if (nonNull(enderecoUpdate.getTipo())) {
        if (!enderecoUpdate.getTipo().getId().equals(endereco.getTipo().getId())) {
          final TipoEndereco tipoEndereco = tipoEnderecoDAO.findById(enderecoUpdate.getTipo().getId());
          if (nonNull(tipoEndereco)) {
            endereco.setTipo(tipoEndereco);
          } else {
            return "Tipo de endereço não encontrado! Tente outro!";
          }
        }
      }
      enderecoRepository.save(endereco);
      return "Endereço atualizado com sucesso!";
    } else {
      return "Erro interno do sistema! Endereço não encontrado!";
    }
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
