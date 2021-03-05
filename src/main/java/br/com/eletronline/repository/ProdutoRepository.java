package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
