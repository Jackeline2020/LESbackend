package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }
