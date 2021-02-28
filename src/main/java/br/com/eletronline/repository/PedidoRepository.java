package br.com.eletronline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.eletronline.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> { }
