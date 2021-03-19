package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> { }
