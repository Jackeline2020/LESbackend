package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> { }
