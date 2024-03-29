package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> { }
