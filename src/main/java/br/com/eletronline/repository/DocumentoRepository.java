package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> { }
