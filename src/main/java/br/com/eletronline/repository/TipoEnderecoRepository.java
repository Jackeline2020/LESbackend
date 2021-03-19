package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.TipoEndereco;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEndereco, Long> { }
