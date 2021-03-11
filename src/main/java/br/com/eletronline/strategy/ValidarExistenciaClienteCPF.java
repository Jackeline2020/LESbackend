package br.com.eletronline.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.util.ValidarCPF;

@Component
public class ValidarExistenciaClienteCPF implements Strategy {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private ValidarCPF validarCPF;

  @Override
  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Cliente cliente = (Cliente) domain;
      return verificarCPF(cliente);
    }
    return "Erro interno do sistema!";
  }

  @Override
  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Cliente;
  }

  private String verificarCPF(final Cliente cliente) {
    final Optional<Cliente> clienteCPF = clienteDAO.findClienteByCPF(cliente.getNome());
    if (clienteCPF.isEmpty()) {
      return validarCPF.validar(cliente.getNome());
    } else if (clienteCPF.get().getId().equals(cliente.getId())) {
      return validarCPF.validar(cliente.getNome());
    } else {
      return "O CPF digitado está indisponível!";
    }
  }

}
