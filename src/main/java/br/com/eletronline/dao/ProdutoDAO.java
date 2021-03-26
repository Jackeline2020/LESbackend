package br.com.eletronline.dao;

import static java.util.Objects.nonNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Produto;
import br.com.eletronline.repository.ProdutoRepository;

@Component
public class ProdutoDAO implements DAO {

  @Autowired private ProdutoRepository produtoRepository;

  @Override
  public String delete(final Domain domain) {
    final Produto produto = (Produto) domain;
    final Produto produtoEncontrado = produtoRepository.findById(produto.getId()).orElse(null);
    if (nonNull(produtoEncontrado)) {
      produtoRepository.delete(produtoEncontrado);
      return "Produto excluído com sucesso!";
    } else {
      return "Erro interno do sistema! Produto não encontrado!";
    }
  }

  @Override
  public List<? extends Domain> find(final Domain domain) {
    final Produto produto = (Produto) domain;
    List<Produto> produtos = new ArrayList<>();
    if (produto.getId() != null) {
      produtos.add(findById(produto.getId()));
    } else {
      produtos = findAll();
    }
    return produtos;
  }

  @Override
  public List<Produto> findAll() {
    return produtoRepository.findAll();
  }

  @Override
  public Produto findById(final Long id) {
    final Produto produto = produtoRepository.findById(id).orElse(null);
    return produto;
  }

  @Override
  public String save(final Domain domain) {
    final Produto produto = (Produto) domain;
      produto.setDataCadastro(LocalDate.now());
      produtoRepository.save(produto);
      return "Produto cadastrado com sucesso!";
  }
  
  @Override
  public String update(final Domain domain) {
    final Produto produtoUpdate = (Produto) domain;
    final Produto produto = produtoRepository.findById(produtoUpdate.getId()).orElse(null);
    if (nonNull(produto)) {
      produto.setDescricao(produtoUpdate.getDescricao() != null ? produtoUpdate.getDescricao() : produto.getDescricao());
      produto.setValor(produtoUpdate.getValor() != null ? produtoUpdate.getValor() : produto.getValor());
      produto.setMarca(produtoUpdate.getMarca() != null ? produtoUpdate.getMarca() : produto.getMarca());
      produto.setModelo(produtoUpdate.getModelo() != null ? produtoUpdate.getModelo() : produto.getModelo());
      produto.setConteudoEmbalagem(produtoUpdate.getConteudoEmbalagem() != null ? produtoUpdate.getConteudoEmbalagem() : produto.getConteudoEmbalagem());
      produto.setGarantia(produtoUpdate.getGarantia() != null ? produtoUpdate.getGarantia() : produto.getGarantia());
      produto.setPeso(produtoUpdate.getPeso() != null ? produtoUpdate.getPeso() : produto.getPeso());
      produtoRepository.save(produto);
      return "Produto atualizado com sucesso!";
    } else {
      return "Erro interno do sistema! Produto não encontrado!";
    }
  }

  @Override
  public String registrarLog(String registro) {
    // TODO Auto-generated method stub
    return null;
  }

}
