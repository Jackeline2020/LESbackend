package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends  JpaRepository<Funcionario, Long> { }
