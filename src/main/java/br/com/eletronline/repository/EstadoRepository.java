package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> { }
