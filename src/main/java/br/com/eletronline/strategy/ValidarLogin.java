package br.com.eletronline.strategy;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.dao.FuncionarioDAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.domain.Domain;
import br.com.eletronline.domain.Funcionario;
import br.com.eletronline.util.CriptografarSenha;

@Component
public class ValidarLogin {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private FuncionarioDAO funcionarioDAO;

  @Autowired private CriptografarSenha criptografarSenha;

  public String processar(final Domain domain) {
    if (verificarInstancia(domain)) {
      final Cliente cliente = (Cliente) domain;
      return verificarLogin(cliente);
    }
    return "Erro interno do sistema!";
  }

  public Boolean verificarInstancia(final Domain domain) {
    return domain instanceof Cliente || domain instanceof Funcionario;
  }

  private String verificarLogin(final Cliente cliente) {
    final Optional<Cliente> clienteEmail = clienteDAO.findClienteByEmail(cliente.getEmail());
    if (!clienteEmail.isEmpty()) {
      if (checkPassword(cliente.getSenha(), clienteEmail.get().getSenha())) {
        return clienteEmail.get().getId().toString();
      }
    }
    final Optional<Funcionario> funcionarioEmail = funcionarioDAO.findFuncionarioByEmail(cliente.getEmail());
    if (!funcionarioEmail.isEmpty()) {
      if (checkPassword(cliente.getSenha(), funcionarioEmail.get().getSenha())) {
        return funcionarioEmail.get().getId().toString();
      }
    }
    return "Email ou senha incorretos! Verifique os campos e tente novamente!";
  }

  private Boolean checkPassword(final String senhaDigitada, final String senhaUsuario) {
    return senhaUsuario.equals(criptografarSenha.criptografar(senhaDigitada));
  }
}
