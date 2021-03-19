package br.com.eletronline.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;

@Component
public class ValidarExistenciaClienteEmail implements Strategy {

  @Autowired private ClienteDAO clienteDAO;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Cliente cliente = (Cliente) domain;
      return verificarEmail(cliente);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Cliente;
  }

  public String verificarEmail(final Cliente cliente) {
    final Optional<Cliente> clienteEmail = clienteDAO.findClienteByEmail(cliente.getEmail());
    if (clienteEmail.isEmpty()) {
      return null;
    } else if (clienteEmail.get().getId().equals(cliente.getId())) {
      return null;
    } else {
      return "O Email digitado está indisponível!";
    }
  }

}
