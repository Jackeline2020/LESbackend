package br.com.eletronline.strategy;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.eletronline.dao.ClienteDAO;
import br.com.eletronline.domain.Cliente;
import br.com.eletronline.util.CriptografarSenha;

@Component
public class PermiteTrocaSenha {

  @Autowired private ClienteDAO clienteDAO;

  @Autowired private CriptografarSenha criptografarSenha;

  public String permiteTrocaSenha(final String senhaNova, final Long clienteId) {
    final String checkParameters = checkParameters(senhaNova, clienteId);
    if (isNullOrEmpty(checkParameters)) {
      final Cliente cliente = clienteDAO.findById(clienteId);
      if (nonNull(cliente)) {
        final String senhaAtualCriptografada = criptografarSenha.criptografar(senhaNova);
        if (cliente.getSenha().equals(senhaAtualCriptografada)) {
          return null;
        } else {
          return "A senha digitada não corresponde!";
        }
      } else {
        return "Cliente não entrado para id: " + clienteId;
      }
    }
    return checkParameters;
  }

  private String checkParameters(final String senhaNova, final Long clienteId) {
    if (isNull(clienteId)) {
      return "Identificador do cliente não pode estar vazio!";
    }
    if (isNullOrEmpty(senhaNova)) {
      return "O campo de Confirmar Senha Atual não pode estar vazio!";
    }
    return null;
  }
}
